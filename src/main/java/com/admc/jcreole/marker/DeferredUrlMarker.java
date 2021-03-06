/*
 * Copyright 2011 Axis Data Management Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.admc.jcreole.marker;

import java.util.List;
import com.admc.jcreole.Sections;

/**
 * This class is named to be used as a general deferred URL resolver, but for
 * now it is Master-Definition-List specific, since that's all we need.
 *
 * @author Blaine Simpson (blaine dot simpson at admc dot com)
 * @since 1.1
 */
public class DeferredUrlMarker extends BufferMarker {
    private String inUrl;
    int targetId = -1;

    public DeferredUrlMarker(int id, String inUrl) {
        super(id);
        this.inUrl = inUrl;
    }

    public String getInUrl() {
        return inUrl;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public void updateBuffer() {
        super.updateBuffer();
        targetSb.insert(offset, (targetId < 0)
                ? inUrl : ("#jcmdef" + targetId + "\" title=\"" + inUrl
                          + "\" class=\"jcreole_mdef"));
    }
}
