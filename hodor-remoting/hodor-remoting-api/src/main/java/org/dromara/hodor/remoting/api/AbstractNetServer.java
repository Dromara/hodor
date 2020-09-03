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

import java.net.InetSocketAddress;

/**
 * AbstractNetServer
 *
 * @author xiaoyu
 */
public abstract class AbstractNetServer implements NetServer, HodorChannelHandler {

    private HodorChannelHandler handler;

    private Attribute attribute;

    private final String host;
    private final Integer port;
    private final Integer ioThreads;
    private final Boolean useEpollNative;

    /**
     * Instantiates a new Abstract net server.
     *
     * @param attribute the properties
     * @param handler   the handler.
     */
    public AbstractNetServer(Attribute attribute, HodorChannelHandler handler) {
        this.handler = handler;
        this.attribute = attribute;
        String defHost = "0.0.0.0";
        host = attribute.getProperty(RemotingConst.HOST_KEY, defHost);
        Integer defPort = 2087;
        port = attribute.getProperty(RemotingConst.PORT_KEY, defPort);
        useEpollNative = attribute.getProperty(RemotingConst.USE_EPOLL_NATIVE, true);
        ioThreads = attribute.getProperty(RemotingConst.IO_THREADS_KEY, Runtime.getRuntime().availableProcessors() << 1);
    }


    /**
     * Whether to avoid the epoll model.
     *
     * @return epoll  native
     */
    public Boolean getUseEpollNative() {
        return useEpollNative;
    }

    @Override
    public void connected(HodorChannel channel) {
        handler.connected(channel);
    }

    @Override
    public void disconnected(HodorChannel channel) {
        handler.disconnected(channel);
    }

    @Override
    public void send(HodorChannel channel, Object message) {
        handler.send(channel, message);
    }

    @Override
    public void received(HodorChannel channel, Object message) {
        handler.received(channel, message);
    }

    @Override
    public void exceptionCaught(HodorChannel channel, Throwable cause) {
        handler.exceptionCaught(channel, cause);
    }

    @Override
    public void timeout(HodorChannel channel) {
        handler.timeout(channel);
    }

    /**
     * Gets host.
     *
     * @return the host
     */
    protected String getHost() {
        return host;
    }

    /**
     * Bind socket address inet socket address.
     *
     * @return the inet socket address
     */
    public InetSocketAddress bindSocketAddress() {
        return new InetSocketAddress(getHost(), getPort());
    }

    /**
     * Gets port.
     *
     * @return the port
     */
    protected Integer getPort() {
        return port;
    }

    /**
     * Gets io threads.
     *
     * @return the io threads
     */
    protected Integer getIoThreads() {
        return ioThreads;
    }

    /**
     * Gets attribute.
     *
     * @return the attribute
     */
    public Attribute getAttribute() {
        return attribute;
    }
}
