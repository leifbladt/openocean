/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.openocean.internal.eep.Base;

import static org.openhab.binding.openocean.OpenOceanBindingConstants.*;

import org.eclipse.smarthome.config.core.Configuration;
import org.eclipse.smarthome.core.library.types.OnOffType;
import org.eclipse.smarthome.core.library.types.UpDownType;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.State;
import org.eclipse.smarthome.core.types.UnDefType;
import org.openhab.binding.openocean.internal.messages.ERP1Message;

/**
 *
 * @author Daniel Weber - Initial contribution
 */
public class PTM200Message extends _RPSMessage {

    static final int On = 0x70;
    static final int Off = 0x50;
    static final int Up = 0x70;
    static final int Down = 0x50;

    public PTM200Message() {
        super();
    }

    public PTM200Message(ERP1Message packet) {
        super(packet);
    }

    @Override
    protected void convertFromCommandImpl(Command command, String channelId, State currentState, Configuration config) {

    }

    @Override
    protected State convertToStateImpl(String channelId, State currentState, Configuration config) {
        if (!isValid()) {
            return UnDefType.UNDEF;
        }

        switch (channelId) {
            case CHANNEL_LIGHT_SWITCHING:
            case CHANNEL_GENERAL_SWITCHING:
                return bytes[0] == On ? OnOffType.ON : OnOffType.OFF;
            case CHANNEL_ROLLERSHUTTER:
                return bytes[0] == Up ? UpDownType.UP : (bytes[0] == Down ? UpDownType.DOWN : UnDefType.UNDEF);
        }

        return UnDefType.UNDEF;
    }
}
