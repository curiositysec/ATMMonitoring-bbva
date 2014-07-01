.. code-block:: sql

		--
		-- PostgreSQL database Create Script
		--

		SET statement_timeout = 0;
		SET client_encoding = 'UTF8';
		SET standard_conforming_strings = off;
		SET check_function_bodies = false;
		SET client_min_messages = warning;
		SET escape_string_warning = off;

		SET search_path = public, pg_catalog;

		SET default_tablespace = '';

		SET default_with_oids = false;

		--
		-- Name: auditable_internet_explorer; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE auditable_internet_explorer (
		id integer NOT NULL,
		date_created timestamp without time zone,
		end_date timestamp without time zone,
		start_date timestamp without time zone,
		internet_explorer_id integer
		);


		ALTER TABLE public.auditable_internet_explorer OWNER TO postgres;

		--
		-- Name: auditable_internet_explorers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE auditable_internet_explorers_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.auditable_internet_explorers_id_seq OWNER TO postgres;

		--
		-- Name: auditable_internet_explorers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('auditable_internet_explorers_id_seq', 1, false);


		--
		-- Name: bank_companies; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE bank_companies (
		id integer NOT NULL,
		name character varying(50) NOT NULL,
		vat_in character varying(15),
		parent_company integer
		);


		ALTER TABLE public.bank_companies OWNER TO postgres;

		--
		-- Name: bank_companies_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE bank_companies_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.bank_companies_id_seq OWNER TO postgres;

		--
		-- Name: bank_companies_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('bank_companies_id_seq', 1, false);


		--
		-- Name: dashboard; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE dashboard (
		id integer NOT NULL,
		columns integer NOT NULL
		);


		ALTER TABLE public.dashboard OWNER TO postgres;

		--
		-- Name: dashboards_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE dashboards_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.dashboards_id_seq OWNER TO postgres;

		--
		-- Name: dashboards_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('dashboards_id_seq', 1, false);


		--
		-- Name: financial_device_jxfs_component; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE financial_device_jxfs_component (
		jxfs_component_id integer NOT NULL,
		financial_device_id integer NOT NULL
		);


		ALTER TABLE public.financial_device_jxfs_component OWNER TO postgres;

		--
		-- Name: financial_device_xfs_component; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE financial_device_xfs_component (
		financial_device_id integer NOT NULL,
		xfs_component_id integer NOT NULL
		);


		ALTER TABLE public.financial_device_xfs_component OWNER TO postgres;

		--
		-- Name: financial_devices; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE financial_devices (
		id integer NOT NULL,
		date_created timestamp without time zone,
		end_date timestamp without time zone,
		start_date timestamp without time zone,
		caption text,
		description text,
		device_instance text,
		device_status text,
		firmware_version text,
		hot_swappable boolean,
		manufacturer text,
		model text,
		name text,
		pm_status text,
		removable boolean,
		replaceable boolean,
		serial_number text,
		universal_id text,
		variant text,
		version text,
		terminal_id integer
		);


		ALTER TABLE public.financial_devices OWNER TO postgres;

		--
		-- Name: financial_devices_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE financial_devices_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.financial_devices_id_seq OWNER TO postgres;

		--
		-- Name: financial_devices_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('financial_devices_id_seq', 1, false);


		--
		-- Name: hardware_devices; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE hardware_devices (
		id integer NOT NULL,
		date_created timestamp without time zone,
		end_date timestamp without time zone,
		start_date timestamp without time zone,
		bits_per_pixel integer,
		adapter_ram integer,
		adapter_type text,
		address_width integer,
		architecture text,
		bytes_per_sector integer,
		capacity bigint,
		caption text,
		colors integer,
		current_bits_per_pixel integer,
		current_clock_speed integer,
		current_horizontal_resolution integer,
		current_language text,
		current_number_of_colors bigint,
		current_refresh_rate integer,
		current_time_zone integer,
		current_usage integer,
		current_vertical_resolution integer,
		data_width integer,
		daylight_in_effect boolean,
		default_ip_gateway text,
		description text,
		device_id text,
		dhcp_enabled boolean,
		dhcp_server text,
		display_type boolean,
		domain text,
		driver_name text,
		ext_clock integer,
		file_system text,
		firmware_revision text,
		free_space bigint,
		hardware_class character varying(100) NOT NULL,
		hardware_type text,
		hardware_version text,
		horizontal_res integer,
		interface_index integer,
		ip_address text,
		ip_subnet text,
		layout text,
		mac_address character varying(17),
		manufacturer text,
		max_baud_rate integer,
		max_clock_speed integer,
		max_media_size integer,
		media_type text,
		model text,
		monitor_manufacturer text,
		monitor_type text,
		name text,
		net_connection_id text,
		net_connection_status text,
		number_of_ports integer,
		number_of_processors integer,
		partitions integer,
		pixels_per_x_logical_inch integer,
		pixels_per_y_logical_inch integer,
		pointing_type integer,
		primary_bios boolean,
		product text,
		protocol_code text,
		protocol_supported integer,
		refresh_rate integer,
		release_date timestamp without time zone,
		sectors_per_track integer,
		serial_number text,
		signature text,
		size_ bigint,
		slot_designation text,
		smbios_major_version integer,
		smbios_minor_version integer,
		smbios_present boolean,
		smbios_version text,
		speed bigint,
		status text,
		status_info text,
		stepping integer,
		tag text,
		total_cylinders integer,
		total_physical_memory bigint,
		tracks_per_cylinder integer,
		usb_version text,
		version text,
		vertical_res integer,
		video_memory integer,
		video_processor text,
		volume_name text,
		volume_serial_number text,
		workgroup text,
		terminal_id integer
		);


		ALTER TABLE public.hardware_devices OWNER TO postgres;

		--
		-- Name: hardware_devices_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE hardware_devices_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.hardware_devices_id_seq OWNER TO postgres;

		--
		-- Name: hardware_devices_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('hardware_devices_id_seq', 1, false);


		--
		-- Name: hotfixes; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE hotfixes (
		id integer NOT NULL,
		date_created timestamp without time zone,
		end_date timestamp without time zone,
		start_date timestamp without time zone,
		description text,
		fix_comments text,
		hotfix_id text,
		numbr integer,
		terminal_id integer
		);


		ALTER TABLE public.hotfixes OWNER TO postgres;

		--
		-- Name: hotfixes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE hotfixes_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.hotfixes_id_seq OWNER TO postgres;

		--
		-- Name: hotfixes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('hotfixes_id_seq', 1, false);


		--
		-- Name: installations; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE installations (
		id integer NOT NULL,
		date_created timestamp without time zone,
		end_date timestamp without time zone,
		start_date timestamp without time zone,
		ip character varying(50),
		location_class character varying(50),
		lu_code character varying(20),
		post character varying(30),
		processed boolean,
		type character varying(50),
		location_id integer
		);


		ALTER TABLE public.installations OWNER TO postgres;

		--
		-- Name: installations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE installations_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.installations_id_seq OWNER TO postgres;

		--
		-- Name: installations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('installations_id_seq', 1, false);


		--
		-- Name: internet_explorers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE internet_explorers (
		id integer NOT NULL,
		build_version integer,
		major_version integer,
		minor_version integer,
		remaining_version text,
		revision_version integer
		);


		ALTER TABLE public.internet_explorers OWNER TO postgres;

		--
		-- Name: internet_explorers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE internet_explorers_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.internet_explorers_id_seq OWNER TO postgres;

		--
		-- Name: internet_explorers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('internet_explorers_id_seq', 1, false);


		--
		-- Name: jxfs_components; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE jxfs_components (
		id integer NOT NULL,
		accept_limit text,
		autopresent text,
		auxiliaries text,
		available_resolution text,
		bait_trap text,
		barcode_capabilites text,
		beep_on_press_supp text,
		beep_supp text,
		bills_taken_sensor text,
		cashbox text,
		category2 text,
		category3 text,
		cd_type text,
		check_vandalism text,
		cheque_capabilities text,
		coins text,
		complex text,
		compound text,
		create_sign_cmd_supported text,
		ctrl_turn text,
		cursor_supp text,
		cylinders text,
		default_input_position text,
		default_output_position text,
		default_rollback_position integer,
		deposit text,
		detector text,
		device_control_name text,
		device_id text,
		device_orientation text,
		device_scan_both_long_side text,
		device_scan_both_short_side text,
		device_service_name text,
		device_type text,
		dispense text,
		display_light_supp text,
		doors text,
		eject_status text,
		entry text,
		env_supply text,
		escrow text,
		escrow_size integer,
		event_on_start_supp text,
		extent text,
		guidlights text,
		id_key text,
		image_capabilities text,
		image_capture text,
		indicators text,
		input_cook_supp text,
		input_positions text,
		input_raw_supp text,
		insert_text_supported text,
		intermediate_stacker text,
		jxfs_class character varying(50) NOT NULL,
		keyboard_lock_supp text,
		keyboard_supp text,
		keys_supp text,
		max_data_length integer,
		max_in_bills integer,
		max_in_coins integer,
		max_led integer,
		max_num_of_chars integer,
		max_out_bills integer,
		max_out_coins integer,
		max_pictures integer,
		max_retract integer,
		max_stacker integer,
		mult_curr_cash_in_supported text,
		number_of_keys integer,
		orientation_to_be_scanned text,
		output_positions text,
		positions text,
		power_off text,
		power_on text,
		print text,
		ptr_capabilities text,
		ptr_control_media text,
		read_fonts text,
		read_form text,
		read_image text,
		read_keyboard_data_w_default text,
		read_micr text,
		read_ocr text,
		read_status text,
		refill text,
		remote_key_load text,
		retain text,
		retract text,
		safe_door_cmd text,
		sade_door_seq text,
		scn_capabilities text,
		secure_key_detail text,
		secure_key_entry_state text,
		secure_key_entry_supp text,
		secure_module_type text,
		sensors text,
		shutter_cmd text,
		silent_alarm text,
		status text,
		supp_chip_presentation_modes text,
		supp_chip_protocols text,
		supp_crypto_modes text,
		supp_fd_keys text,
		supp_pin_formats text,
		supp_read_tracks text,
		supp_text_attributes text,
		supp_validation_algorithms text,
		supp_write_hico_tracks text,
		supp_write_tracks text,
		test_cash_unit text,
		transport text,
		trusted_user text,
		unfit text,
		vendor_data text,
		write_form text,
		write_mode text
		);


		ALTER TABLE public.jxfs_components OWNER TO postgres;

		--
		-- Name: jxfs_components_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE jxfs_components_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.jxfs_components_id_seq OWNER TO postgres;

		--
		-- Name: jxfs_components_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('jxfs_components_id_seq', 1, false);


		--
		-- Name: locations; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE locations (
		id integer NOT NULL,
		address_city text,
		address_country text,
		address_number text,
		address_postcode text,
		address_street text,
		bank character varying(50),
		bank_company character varying(50),
		coord_x double precision,
		coord_y double precision,
		displaced boolean,
		office character varying(50),
		public_access boolean
		);


		ALTER TABLE public.locations OWNER TO postgres;

		--
		-- Name: locations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE locations_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.locations_id_seq OWNER TO postgres;

		--
		-- Name: locations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('locations_id_seq', 1, false);


		--
		-- Name: logical_cash_units; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE logical_cash_units (
		id integer NOT NULL,
		currency_id text,
		maximum integer,
		minimum integer,
		name text,
		type text,
		unit_id integer,
		vals text,
		xfs_component_id integer
		);


		ALTER TABLE public.logical_cash_units OWNER TO postgres;

		--
		-- Name: logical_cash_units_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE logical_cash_units_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.logical_cash_units_id_seq OWNER TO postgres;

		--
		-- Name: logical_cash_units_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('logical_cash_units_id_seq', 1, false);


		--
		-- Name: operating_systems; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE operating_systems (
		id integer NOT NULL,
		build_version integer,
		major_version integer,
		manufacturer text,
		minor_version integer,
		name text,
		organization text,
		os_language text,
		os_type text,
		remaining_version text,
		revision_version integer,
		serial_number text,
		service_pack_build_version integer,
		service_pack_major_version integer,
		service_pack_minor_version integer,
		service_pack_remaining_version text,
		service_pack_revision_version integer
		);


		ALTER TABLE public.operating_systems OWNER TO postgres;

		--
		-- Name: operating_systems_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE operating_systems_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.operating_systems_id_seq OWNER TO postgres;

		--
		-- Name: operating_systems_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('operating_systems_id_seq', 1, false);


		--
		-- Name: physical_cash_units; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE physical_cash_units (
		id integer NOT NULL,
		hardware_sensor boolean,
		maximum integer,
		name text,
		unit_id integer,
		logical_cash_unit_id integer
		);


		ALTER TABLE public.physical_cash_units OWNER TO postgres;

		--
		-- Name: physical_cash_units_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE physical_cash_units_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.physical_cash_units_id_seq OWNER TO postgres;

		--
		-- Name: physical_cash_units_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('physical_cash_units_id_seq', 1, false);


		--
		-- Name: queries; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

