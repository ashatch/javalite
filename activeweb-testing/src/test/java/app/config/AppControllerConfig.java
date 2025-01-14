/*
Copyright 2009-2016 Igor Polevoy

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at 

http://www.apache.org/licenses/LICENSE-2.0 

Unless required by applicable law or agreed to in writing, software 
distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions and 
limitations under the License. 
*/

package app.config;

import app.controllers.ExcludeActionController;
import app.controllers.ExcludeController;
import app.filters.IncludeExcludeActionFilter;
import app.filters.IncludeExcludeFilter;
import org.javalite.activeweb.AbstractControllerConfig;
import org.javalite.activeweb.AppContext;

import app.filters.InjectionRedirectFilter;

/**
 * @author Igor Polevoy
 */
public class AppControllerConfig extends AbstractControllerConfig {

    public void init(AppContext appContext) {
        add(new InjectionRedirectFilter());

        //this filter will apply to the IncludeController
        add(new IncludeExcludeFilter()).exceptFor(ExcludeController.class);


        add(new IncludeExcludeActionFilter()).to(ExcludeActionController.class).excludeActions("exclude");

    }
}
