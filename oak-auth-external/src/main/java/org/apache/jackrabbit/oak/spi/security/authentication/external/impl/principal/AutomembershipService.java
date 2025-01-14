/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jackrabbit.oak.spi.security.authentication.external.impl.principal;

import org.apache.jackrabbit.api.security.user.UserManager;
import org.apache.jackrabbit.oak.api.Root;
import org.apache.jackrabbit.oak.namepath.NamePathMapper;
import org.apache.jackrabbit.oak.spi.security.user.DynamicMembershipProvider;
import org.apache.jackrabbit.oak.spi.security.user.DynamicMembershipService;
import org.jetbrains.annotations.NotNull;

public class AutomembershipService implements DynamicMembershipService {
    
    private final SyncConfigTracker scTracker;
    
    public AutomembershipService(@NotNull SyncConfigTracker scTracker) {
        this.scTracker = scTracker;
    }
    
    @Override
    @NotNull
    public DynamicMembershipProvider getDynamicMembershipProvider(@NotNull Root root, @NotNull UserManager userManager, @NotNull NamePathMapper namePathMapper) {
        if (scTracker.isEnabled()) {
            return new AutoMembershipProvider(root, userManager, namePathMapper, scTracker.getAutoMembership(), scTracker.getAutoMembershipConfig());
        } else {
            return DynamicMembershipProvider.EMPTY;
        }
    }
}