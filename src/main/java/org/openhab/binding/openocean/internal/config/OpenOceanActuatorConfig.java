/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.openocean.internal.config;

/**
 *
 * @author Daniel Weber - Initial contribution
 */
public class OpenOceanActuatorConfig extends OpenOceanBaseConfig {

    public int channel;
    public int senderIdOffset = -1;
    public String manufacturerId;
    public String teachInType;

    public String sendingEEPId;

    public int pollingInterval;

    public boolean broadcastMessages;

    public String getSendingEEPId() {
        if (sendingEEPId == null || sendingEEPId.isEmpty()) {
            return super.getReceivingEEPId();
        }

        return sendingEEPId;
    }
}
