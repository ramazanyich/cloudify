/*******************************************************************************
 * Copyright (c) 2011 GigaSpaces Technologies Ltd. All rights reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.cloudifysource.shell.commands;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.cloudifysource.shell.AbstractAdminFacade;
import org.cloudifysource.shell.AdminFacade;
import org.cloudifysource.shell.Constants;
import org.fusesource.jansi.Ansi.Color;

/**
 * @author rafi, adaml, barakm
 * @since 2.0.0
 * 
 *        Connects to a REST server.
 * 
 *        Required arguments:
 *         URL - The URL of the REST server
 * 
 *        Optional arguments:
 *         user - The username for a secure connection to the rest server
 *         pwd - The password for a secure connection to the rest server
 * 
 *        Command syntax: connect [-user username] [-pwd password] URL
 */
@Command(scope = "cloudify", name = "connect", description = "connects to the target admin REST server")
public class Connect extends AbstractGSCommand {

	@Option(required = false, description = "The username when connecting to a secure admin server", name = "-user")
	private String user;

	@Option(required = false, description = "The password when connecting to a secure admin server", name = "-pwd",
			aliases = { "-password" })
	private String password;

	@Argument(required = true, name = "URL", description = "the URL of the REST admin server to connect to")
	private String url = "";

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object doExecute() throws Exception {
		final AdminFacade adminFacade = (AbstractAdminFacade) session.get(Constants.ADMIN_FACADE);
		adminFacade.connect(user, password, url);
		// We keep a reference to the facade so that the CompleterValue methods will be able
		// to access it.
		setRestAdminFacade(adminFacade);

		return getFormattedMessage("connected_successfully", Color.GREEN);
	}

}
