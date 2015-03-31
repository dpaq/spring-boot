/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.actuate.endpoint.jmx;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.actuate.endpoint.ShutdownEndpoint;
import org.springframework.boot.json.jackson.ObjectMapperProvider;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * Special endpoint wrapper for {@link ShutdownEndpoint}.
 *
 * @author Christian Dupuis
 */
@ManagedResource
public class ShutdownEndpointMBean extends EndpointMBean {

	public ShutdownEndpointMBean(String beanName, Endpoint<?> endpoint,
			ObjectMapperProvider objectMapperProvider) {
		super(beanName, endpoint, objectMapperProvider);
	}

	@ManagedOperation(description = "Shutdown the ApplicationContext")
	public Object shutdown() {
		return convert(getEndpoint().invoke());
	}
}
