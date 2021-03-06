/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.openocean.internal.messages;

import org.openhab.binding.openocean.internal.transceiver.Helper;

/**
 *
 * @author Daniel Weber - Initial contribution
 */
public class RDBaseIdResponse extends Response {

    private int[] baseId = null;
    private int remainingWriteCycles = 0;

    public RDBaseIdResponse(Response response) {
        this(response.getPayload().length, response.getOptionalPayload().length,
                Helper.concatAll(response.getPayload(), response.getOptionalPayload()));
    }

    RDBaseIdResponse(int dataLength, int optionalDataLength, int[] payload) {
        super(dataLength, optionalDataLength, payload);

        if (this.payload == null || this.payload.length != 5 || this.optionalPayload == null
                || this.optionalPayload.length != 1) {
            return;
        }

        baseId = getPayload(1, 4);
        remainingWriteCycles = optionalPayload[0];

        _isValid = true;
    }

    public final int[] getBaseId() {
        return baseId;
    }

    public int getRemainingWriteCycles() {
        return remainingWriteCycles;
    }

}
