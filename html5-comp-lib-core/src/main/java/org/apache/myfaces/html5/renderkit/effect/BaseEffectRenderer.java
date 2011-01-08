/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.myfaces.html5.renderkit.effect;

import org.apache.myfaces.html5.component.effect.AbstractBaseEffect;
import org.apache.myfaces.shared_html5.renderkit.RendererUtils;
import org.apache.myfaces.shared_html5.renderkit.html.HtmlRenderer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;

public abstract class BaseEffectRenderer extends HtmlRenderer {

    @Override
    public void encodeBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException {
        super.encodeBegin(facesContext, uiComponent);

        RendererUtils.checkParamValidity(facesContext, uiComponent, AbstractBaseEffect.class);

        AbstractBaseEffect component = (AbstractBaseEffect) uiComponent;

        ResponseWriter writer = facesContext.getResponseWriter();
        writer.write(" " +  getEffectDefinition(facesContext, component) + " ");
    }

    protected abstract String getEffectDefinition(FacesContext facesContext, AbstractBaseEffect component);

}
