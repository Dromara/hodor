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

/**
 * HodorChannelHandler
 *
 * @author xiaoyu
 */
public interface HodorChannelHandler {

    /**
     * Connection.
     *
     * @param channel the channel
     */
    void connected(HodorChannel channel);

    /**
     * Disconnected.
     *
     * @param channel the channel
     */
    void disconnected(HodorChannel channel);

    /**
     * Send.
     *
     * @param channel the channel
     * @param message the message
     */
    void send(HodorChannel channel, Object message);

    /**
     * Received.
     *
     * @param channel the channel
     * @param message the message
     */
    void received(HodorChannel channel, Object message) throws Exception;

    /**
     * Exception caught.
     *
     * @param channel the channel
     * @param cause   the cause
     */
    void exceptionCaught(HodorChannel channel, Throwable cause);

    /**
     * Timeout.
     *
     * @param channel the channel
     */
    void timeout(HodorChannel channel);
}
