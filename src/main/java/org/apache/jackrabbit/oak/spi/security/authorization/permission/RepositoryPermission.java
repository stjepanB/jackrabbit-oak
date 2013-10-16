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
package org.apache.jackrabbit.oak.spi.security.authorization.permission;

/**
 * RepositoryPermission... TODO
 */
public interface RepositoryPermission {

    /**
     * Returns {@code true} if the specified repository level permissions are
     * {@code granted}; false otherwise.
     *
     * @param repositoryPermissions Any valid repository level permission such as
     * for example:
     * <ul>
     *     <li>{@link Permissions#NAMESPACE_MANAGEMENT}</li>
     *     <li>{@link Permissions#NODE_TYPE_DEFINITION_MANAGEMENT}</li>
     *     <li>{@link Permissions#PRIVILEGE_MANAGEMENT}</li>
     *     <li>{@link Permissions#WORKSPACE_MANAGEMENT}</li>
     * </ul>
     * @return {@code true} if the specified repository level permissions are
     * {@code granted}; false otherwise.
     */
    boolean isGranted(long repositoryPermissions);

    RepositoryPermission EMPTY = new RepositoryPermission() {
        @Override
        public boolean isGranted(long repositoryPermissions) {
            return false;
        }
    };

    RepositoryPermission ALL = new RepositoryPermission() {
        @Override
        public boolean isGranted(long repositoryPermissions) {
            return true;
        }
    };
}