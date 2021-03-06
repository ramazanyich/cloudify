/*******************************************************************************
 * Copyright (c) 2011 GigaSpaces Technologies Ltd. All rights reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *******************************************************************************/
package org.cloudifysource.dsl.internal;

/**********
 * Enum for cloudify error messages, including keys to message bundle.
 *
 * @author barakme
 *
 * @since 2.3.0
 */
public enum CloudifyErrorMessages {

	/*********
	 * Indicates keystore file could not be validated.
	 */
	INVALID_KEYSTORE_FILE("invalid_keystore_file", 1),
	/*********
	 * Server response Json parse error.
	 */
	JSON_PARSE_ERROR("CLI_unable_to_parse_to_JSON", 1),

	/******
	 * CLI Input included a json element that could not be parsed.
	 */
	CLIENT_JSON_PARSE_ERROR("Client_unable_to_parse_to_JSON", 2),
	/********
	 * Indicates an unexpected error occured in the server.
	 */
	GENERAL_SERVER_ERROR("general_server_error", 1),
	/******
	 * If service recipe refers to missing template.
	 */
	MISSING_TEMPLATE("missing_template", 1),
	/**
	 * If the cloud overrides given is to long. the file size limit is 10K.
	 */
	CLOUD_OVERRIDES_TO_LONG("cloud_overrides_file_to_long", 0),

	/*******
	 * Attempted to install service with name of already installed service.
	 */
	SERVICE_ALREADY_INSTALLED("service_already_installed", 1),

	/**
	 * Access to the resource is denied, permission not granted.
	 */
	NO_PERMISSION_ACCESS_DENIED("no_permission_access_is_denied", 0),

	/**
	 * Access to the resource is denied, permission not granted.
	 */
	BAD_CREDENTIALS("bad_credentials", 0),

	/**
	 * Byon template's configuration is missing nodes list.
	 */
	MISSING_NODES_LIST("prov_missing_nodesList_configuration", 1),

	/**
	 * Setting server security profile (nonsecure/secure/ssl).
	 */
	SETTING_SERVER_SECURITY_PROFILE("set_security_profile", 1),

	/**
	 * communication error.
	 */
	COMMUNICATION_ERROR("comm_error", 2),

	/******
	 * If service recipe refers to missing template.
	 */
	TEMPLATE_IN_USE("failed_to_remove_template_in_use", 2),

	/******
	 * If failed to add templates.
	 */
	FAILED_TO_ADD_TEMPLATES("failed_to_add_templates", 1),

	/******
	 * If partly failed to add templates (some added successfully).
	 */
	PARTLY_FAILED_TO_ADD_TEMPLATES("partly_failed_to_add_templates", 2),

	/******
	 * The application name contains invalid chars.
	 */
	APPLICATION_NAME_INVALID_CHARS("application_name_invalid_chars", 1),

	/******
	 * The service name contains invalid chars.
	 */
	SERVICE_NAME_INVALID_CHARS("service_name_invalid_chars", 1),

	/**
	 * if a user specified instance memory that was to big in respect to machine memory specified in the template.
	 */
	INSUFFICIENT_MEMORY("insufficient_memory", 4),

	/**
	 * Indicates a failure happened while provisioning machines by the cloud driver.
	 */
	CLOUD_API_ERROR("cloud_api_error", 1),

	/**
	 * Indicates a command tried to locate existing management servers but cloud driver does not support this feature.
	 */
	MANAGEMENT_LOCATOR_NOT_SUPPORTED("management_locator_not_supported", 1),

	/**
	 * Indicates a command tried to locate management servers but none were found.
	 */
	MANAGEMENT_SERVERS_NOT_LOCATED("management_servers_not_located", 0),

	/**
	 * Indicates a failure in accessing Cloud API.
	 */
	MANAGEMENT_SERVERS_FAILED_TO_READ("management_servers_failed_to_read", 1),

	/**
	 * Indicates number of returned servers from management locator does not match expected value.
	 */
	MANAGEMENT_SERVERS_NUMBER_NOT_MATCH("management_servers_number_not_match", 2),

	/**
	 * Management servers details.
	 */
	MANAGEMENT_SERVERS_DETAILS("management_servers_details", 3),
	/**
	 * Management servers details.
	 */
	MANAGEMENT_SERVERS_SHUTDOWN_NOT_ALLOWED_ON_LOCALCLOUD("shutdown_managers_not_allowed_on_localcloud", 0),

	/**
	 * REST API not connected.
	 */
	REST_NOT_CONNECTED("not_connected", 0),

	MANAGEMENT_SERVERS_WAITING_FOR_SHUTDOWN("shutdown_managers_initiated", 1),

	MANAGEMENT_SERVERS_MANAGER_DOWN("shutdown_managers_manager_down", 1),

	MANAGEMENT_SERVERS_SHUTDOWN_SUCCESS("shutdown_managers_completed", 0),

	MANAGEMENT_SERVERS_SHUTDOWN_FAIL("shutdown_managers_timeout", 0),

	FILE_NOT_EXISTS("file_doesnt_exist", 1),
	
	/**
	 * Cloud validations
	 */
	EVENT_ATTEMPT_TO_VALIDATE_CLOUD_CONFIG("try_to_validate_cloud_configuration", 0),
	
	EVENT_CLOUD_CONFIG_VALIDATED("cloud_configuration_validated", 0),
	
	EVENT_VALIDATING_PROVIDER_OR_API_NAME("validating_provider_or_api_name", 1),
	
	EVENT_VALIDATING_CLOUD_CREDENTIALS("validating_cloud_credentials", 0),
	
	EVENT_VALIDATING_TEMPLATE("validating_template", 1),
	
	EVENT_TEMPLATE_VALIDATED("template_validated", 1),
	
	EVENT_VALIDATING_IMAGE_ID("validating_image_id", 1),
	
	EVENT_VALIDATING_IMAGES("validating_images", 0),
	
	EVENT_VALIDATING_HARDWARE_ID("validating_hardware_id", 1),
	
	EVENT_VALIDATING_HARDWARE_PROFILES("validating_hardware_profiles", 0),
	
	EVENT_VALIDATING_LOCATION_ID("validating_location_id", 1),
	
	EVENT_VALIDATING_LOCATIONS("validating_locations", 0),
	
	EVENT_VALIDATING_IMAGE_HARDWARE_LOCATION_COMBINATION("validating_image_hardware_location_combination", 1),
	
	EVENT_VALIDATING_SECURITY_GROUPS("validating_security_groups", 0),
	
	EVENT_VALIDATING_KEY_PAIRS("validating_key_pairs", 0),
	
	EVENT_VALIDATING_CLOUDIFY_URL("validating_cloudify_url", 0),
	
	EVENT_VALIDATING_TEMPLATE_OVERRIDES("validating_template_overrides", 0),
	

	// CHECKSTYLE:OFF
	;
	// CHECKSTYLE:ON

	private final int numberOfParameters;
	private final String name;

	CloudifyErrorMessages(final String name, final int numberOfParameters) {
		this.name = name;
		this.numberOfParameters = numberOfParameters;
	}

	public int getNumberOfParameters() {
		return numberOfParameters;
	}

	public String getName() {
		return name;
	}

}
