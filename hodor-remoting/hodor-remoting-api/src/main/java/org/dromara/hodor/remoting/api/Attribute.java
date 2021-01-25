/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.dromara.hodor.remoting.api;

import java.util.Properties;

/**
 * Attribute.
 * <p>
 *
 * @author sixh
 */
public class Attribute extends Properties {

    private static final long serialVersionUID = 3263878045463371449L;

    /**
     * Gets property.
     *
     * @param <T> the type parameter
     * @param key the key
     * @param def the def 默认值.
     * @return the property
     */
    @SuppressWarnings("unchecked")
    public <T> T getProperty(String key, T def) {
        Object val = super.get(key);
        return (T) ((val == null) ? def : val);
    }
}
