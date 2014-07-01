.. code-block:: sql

		CREATE TABLE queries (
		id integer NOT NULL,
		creation_date timestamp without time zone,
		description character varying(200),
		feat_sw_cb1 boolean,
		feat_sw_cb2 boolean,
		feat_sw_cb3 boolean,
		feat_sw_cb4 boolean,
		feat_sw_cb5 boolean,
		feat_sw_c11 character varying(50),
		feat_sw_c12 character varying(50),
		feat_sw_c21 character varying(50),
		feat_sw_c22 character varying(50),
		feat_sw_c31 character varying(50),
		feat_sw_c32 character varying(50),
		feat_sw_c41 character varying(50),
		feat_sw_c42 character varying(50),
		feat_sw_c51 character varying(50),
		feat_sw_c52 character varying(50),
		feat_sw_f1 character varying(150),
		feat_sw_f2 character varying(150),
		feat_sw_f3 character varying(150),
		feat_sw_f4 character varying(150),
		feat_sw_f5 character varying(150),
		financial_dev_cb1 boolean,
		financial_dev_cb2 boolean,
		financial_dev_cb3 boolean,
		financial_dev_cb4 boolean,
		financial_dev_cb5 boolean,
		financial_dev_c11 character varying(50),
		financial_dev_c12 character varying(50),
		financial_dev_c21 character varying(50),
		financial_dev_c22 character varying(50),
		financial_dev_c31 character varying(50),
		financial_dev_c32 character varying(50),
		financial_dev_c41 character varying(50),
		financial_dev_c42 character varying(50),
		financial_dev_c51 character varying(50),
		financial_dev_c52 character varying(50),
		financial_dev_f1 character varying(150),
		financial_dev_f2 character varying(150),
		financial_dev_f3 character varying(150),
		financial_dev_f4 character varying(150),
		financial_dev_f5 character varying(150),
		hw_device_cb1 boolean,
		hw_device_cb2 boolean,
		hw_device_cb3 boolean,
		hw_device_cb4 boolean,
		hw_device_cb5 boolean,
		hw_device_c11 character varying(50),
		hw_device_c12 character varying(50),
		hw_device_c13 character varying(50),
		hw_device_c21 character varying(50),
		hw_device_c22 character varying(50),
		hw_device_c23 character varying(50),
		hw_device_c31 character varying(50),
		hw_device_c32 character varying(50),
		hw_device_c33 character varying(50),
		hw_device_c41 character varying(50),
		hw_device_c42 character varying(50),
		hw_device_c43 character varying(50),
		hw_device_c51 character varying(50),
		hw_device_c52 character varying(50),
		hw_device_c53 character varying(50),
		hw_device_f1 character varying(150),
		hw_device_f2 character varying(150),
		hw_device_f3 character varying(150),
		hw_device_f4 character varying(150),
		hw_device_f5 character varying(150),
		hotfix_cb1 boolean,
		hotfix_cb2 boolean,
		hotfix_cb3 boolean,
		hotfix_cb4 boolean,
		hotfix_cb5 boolean,
		hotfix_c11 character varying(50),
		hotfix_c12 character varying(50),
		hotfix_c21 character varying(50),
		hotfix_c22 character varying(50),
		hotfix_c31 character varying(50),
		hotfix_c32 character varying(50),
		hotfix_c41 character varying(50),
		hotfix_c42 character varying(50),
		hotfix_c51 character varying(50),
		hotfix_c52 character varying(50),
		hotfix_f1 character varying(150),
		hotfix_f2 character varying(150),
		hotfix_f3 character varying(150),
		hotfix_f4 character varying(150),
		hotfix_f5 character varying(150),
		ie_cb1 boolean,
		ie_cb2 boolean,
		ie_c11 character varying(50),
		ie_c12 character varying(50),
		ie_c21 character varying(50),
		ie_c22 character varying(50),
		ie_f1 character varying(150),
		ie_f2 character varying(150),
		jxfs_component_cb1 boolean,
		jxfs_component_cb2 boolean,
		jxfs_component_cb3 boolean,
		jxfs_component_cb4 boolean,
		jxfs_component_cb5 boolean,
		jxfs_component_c11 character varying(50),
		jxfs_component_c12 character varying(50),
		jxfs_component_c21 character varying(50),
		jxfs_component_c22 character varying(50),
		jxfs_component_c31 character varying(50),
		jxfs_component_c32 character varying(50),
		jxfs_component_c41 character varying(50),
		jxfs_component_c42 character varying(50),
		jxfs_component_c51 character varying(50),
		jxfs_component_c52 character varying(50),
		jxfs_component_f1 character varying(150),
		jxfs_component_f2 character varying(150),
		jxfs_component_f3 character varying(150),
		jxfs_component_f4 character varying(150),
		jxfs_component_f5 character varying(150),
		locale character varying(10),
		query_name character varying(50) NOT NULL,
		op_system_cb1 boolean,
		op_system_cb2 boolean,
		op_system_cb3 boolean,
		op_system_cb4 boolean,
		op_system_cb5 boolean,
		op_system_c11 character varying(50),
		op_system_c12 character varying(50),
		op_system_c21 character varying(50),
		op_system_c22 character varying(50),
		op_system_c31 character varying(50),
		op_system_c32 character varying(50),
		op_system_c41 character varying(50),
		op_system_c42 character varying(50),
		op_system_c51 character varying(50),
		op_system_c52 character varying(50),
		op_system_f1 character varying(150),
		op_system_f2 character varying(150),
		op_system_f3 character varying(150),
		op_system_f4 character varying(150),
		op_system_f5 character varying(150),
		software_cb1 boolean,
		software_cb2 boolean,
		software_cb3 boolean,
		software_cb4 boolean,
		software_cb5 boolean,
		software_c11 character varying(50),
		software_c12 character varying(50),
		software_c21 character varying(50),
		software_c22 character varying(50),
		software_c31 character varying(50),
		software_c32 character varying(50),
		software_c41 character varying(50),
		software_c42 character varying(50),
		software_c51 character varying(50),
		software_c52 character varying(50),
		software_f1 character varying(150),
		software_f2 character varying(150),
		software_f3 character varying(150),
		software_f4 character varying(150),
		software_f5 character varying(150),
		terminal_cb1 boolean,
		terminal_cb2 boolean,
		terminal_cb3 boolean,
		terminal_cb4 boolean,
		terminal_cb5 boolean,
		terminal_c11 character varying(50),
		terminal_c12 character varying(50),
		terminal_c21 character varying(50),
		terminal_c22 character varying(50),
		terminal_c31 character varying(50),
		terminal_c32 character varying(50),
		terminal_c41 character varying(50),
		terminal_c42 character varying(50),
		terminal_c51 character varying(50),
		terminal_c52 character varying(50),
		terminal_f1 character varying(150),
		terminal_f2 character varying(150),
		terminal_f3 character varying(150),
		terminal_f4 character varying(150),
		terminal_f5 character varying(150),
		xfs_component_cb1 boolean,
		xfs_component_cb2 boolean,
		xfs_component_cb3 boolean,
		xfs_component_cb4 boolean,
		xfs_component_cb5 boolean,
		xfs_component_c11 character varying(50),
		xfs_component_c12 character varying(50),
		xfs_component_c21 character varying(50),
		xfs_component_c22 character varying(50),
		xfs_component_c31 character varying(50),
		xfs_component_c32 character varying(50),
		xfs_component_c41 character varying(50),
		xfs_component_c42 character varying(50),
		xfs_component_c51 character varying(50),
		xfs_component_c52 character varying(50),
		xfs_component_f1 character varying(150),
		xfs_component_f2 character varying(150),
		xfs_component_f3 character varying(150),
		xfs_component_f4 character varying(150),
		xfs_component_f5 character varying(150),
		xfs_sw_cb1 boolean,
		xfs_sw_cb2 boolean,
		xfs_sw_cb3 boolean,
		xfs_sw_cb4 boolean,
		xfs_sw_cb5 boolean,
		xfs_sw_c11 character varying(50),
		xfs_sw_c12 character varying(50),
		xfs_sw_c21 character varying(50),
		xfs_sw_c22 character varying(50),
		xfs_sw_c31 character varying(50),
		xfs_sw_c32 character varying(50),
		xfs_sw_c41 character varying(50),
		xfs_sw_c42 character varying(50),
		xfs_sw_c51 character varying(50),
		xfs_sw_c52 character varying(50),
		xfs_sw_f1 character varying(150),
		xfs_sw_f2 character varying(150),
		xfs_sw_f3 character varying(150),
		xfs_sw_f4 character varying(150),
		xfs_sw_f5 character varying(150),
		user_id integer
		);


		ALTER TABLE public.queries OWNER TO postgres;

		--
		-- Name: queries_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE queries_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.queries_id_seq OWNER TO postgres;

		--
		-- Name: queries_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('queries_id_seq', 1, false);


		--
		-- Name: roles; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE roles (
		id integer NOT NULL,
		can_access_reports boolean DEFAULT false,
		can_edit_terminals boolean DEFAULT false,
		can_request_update boolean DEFAULT false,
		can_schedule boolean DEFAULT false,
		can_use_queries boolean DEFAULT false,
		can_view_terminals boolean DEFAULT false,
		description character varying(300),
		manageable boolean,
		name character varying(100) NOT NULL,
		user_manager boolean DEFAULT false
		);


		ALTER TABLE public.roles OWNER TO postgres;

		--
		-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE roles_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.roles_id_seq OWNER TO postgres;

		--
		-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('roles_id_seq', 5, false);


		--
		-- Name: scheduled_updates; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE scheduled_updates (
		id integer NOT NULL,
		description character varying(200),
		hours smallint,
		minutes smallint,
		month_day smallint,
		name character varying(50),
		start_date timestamp without time zone,
		time_zone smallint,
		week_day smallint,
		query_id integer,
		CONSTRAINT scheduled_updates_hours_check CHECK (((hours >= 0) AND (hours <= 23))),
		CONSTRAINT scheduled_updates_minutes_check CHECK (((minutes >= 0) AND (minutes <= 59))),
		CONSTRAINT scheduled_updates_month_day_check CHECK (((month_day >= 1) AND (month_day <= 31))),
		CONSTRAINT scheduled_updates_time_zone_check CHECK (((time_zone >= (-12)) AND (time_zone <= 12))),
		CONSTRAINT scheduled_updates_week_day_check CHECK (((week_day <= 6) AND (week_day >= 0)))
		);


		ALTER TABLE public.scheduled_updates OWNER TO postgres;

		--
		-- Name: scheduled_updates_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE scheduled_updates_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.scheduled_updates_id_seq OWNER TO postgres;

		--
		-- Name: scheduled_updates_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('scheduled_updates_id_seq', 1, false);


		--
		-- Name: software; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE software (
		id integer NOT NULL,
		build_version integer,
		caption text,
		description text,
		identifying_number text,
		install_date timestamp without time zone,
		language text,
		local_package text,
		major_version integer,
		minor_version integer,
		name text,
		package_name text,
		product_id text,
		remaining_version text,
		revision_version integer,
		sw_type text,
		vendor text
		);


		ALTER TABLE public.software OWNER TO postgres;

		--
		-- Name: software_aggregates; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE software_aggregates (
		id integer NOT NULL,
		date_created timestamp without time zone,
		end_date timestamp without time zone,
		start_date timestamp without time zone,
		build_version integer,
		description text,
		major_version integer,
		minor_version integer,
		name text,
		numbr integer,
		profile text,
		remaining_version text,
		revision_version integer
		);


		ALTER TABLE public.software_aggregates OWNER TO postgres;

		--
		-- Name: software_aggregates_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE software_aggregates_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.software_aggregates_id_seq OWNER TO postgres;

		--
		-- Name: software_aggregates_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('software_aggregates_id_seq', 1, false);


		--
		-- Name: software_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE software_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.software_id_seq OWNER TO postgres;

		--
		-- Name: software_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('software_id_seq', 1, false);


		--
		-- Name: t_config_op_system; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE t_config_op_system (
		terminal_config_id integer NOT NULL,
		operating_system_id integer NOT NULL
		);


		ALTER TABLE public.t_config_op_system OWNER TO postgres;

		--
		-- Name: terminal_auditable_internet_explorer; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE terminal_auditable_internet_explorer (
		terminal_id integer NOT NULL,
		auditable_internet_explorer_id integer NOT NULL
		);


		ALTER TABLE public.terminal_auditable_internet_explorer OWNER TO postgres;

		--
		-- Name: terminal_config_software; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE terminal_config_software (
		terminal_config_id integer NOT NULL,
		software_id integer NOT NULL
		);


		ALTER TABLE public.terminal_config_software OWNER TO postgres;

		--
		-- Name: terminal_configs; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE terminal_configs (
		id integer NOT NULL,
		date_created timestamp without time zone,
		end_date timestamp without time zone,
		start_date timestamp without time zone,
		terminal_id integer
		);


		ALTER TABLE public.terminal_configs OWNER TO postgres;

		--
		-- Name: terminal_configs_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE terminal_configs_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.terminal_configs_id_seq OWNER TO postgres;

		--
		-- Name: terminal_configs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('terminal_configs_id_seq', 1, false);


		--
		-- Name: terminal_models; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE terminal_models (
		id integer NOT NULL,
		depth integer,
		height integer,
		manufacturer character varying(50),
		max_weight double precision,
		min_weight double precision,
		model character varying(50),
		nickname character varying(50),
		photo bytea,
		product_class character varying(50),
		width integer
		);


		ALTER TABLE public.terminal_models OWNER TO postgres;

		--
		-- Name: terminal_models_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE terminal_models_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.terminal_models_id_seq OWNER TO postgres;

		--
		-- Name: terminal_models_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('terminal_models_id_seq', 1, false);


		--
		-- Name: terminal_software_aggregate; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE terminal_software_aggregate (
		terminal_id integer NOT NULL,
		software_aggregate_id integer NOT NULL
		);


		ALTER TABLE public.terminal_software_aggregate OWNER TO postgres;

		--
		-- Name: terminals; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE terminals (
		id integer NOT NULL,
		bank text,
		branch text,
		front_replenish boolean,
		geographic_address text,
		ip character varying(23),
		mac character varying(17),
		manufacturing_site text,
		matricula bigint NOT NULL,
		product_class_description text,
		serial_number text,
		terminal_type text,
		terminal_vendor text,
		tracer_number text,
		bank_id integer,
		terminal_model_id integer
		);


		ALTER TABLE public.terminals OWNER TO postgres;

		--
		-- Name: terminals_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE terminals_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.terminals_id_seq OWNER TO postgres;

		--
		-- Name: terminals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('terminals_id_seq', 1, false);


		--
		-- Name: terminals_installations; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE terminals_installations (
		terminals_id integer NOT NULL,
		installations_id integer NOT NULL
		);


		ALTER TABLE public.terminals_installations OWNER TO postgres;

		--
		-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE users (
		id integer NOT NULL,
		firstname character varying(30),
		last_login timestamp without time zone,
		lastname character varying(60),
		passw character varying(80) NOT NULL,
		username character varying(20) NOT NULL,
		bank_id integer,
		dashboard_id integer,
		role_id integer
		);


		ALTER TABLE public.users OWNER TO postgres;

		--
		-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE users_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.users_id_seq OWNER TO postgres;

		--
		-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('users_id_seq', 4, false);


		--
		-- Name: widget; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE widget (
		id integer NOT NULL,
		chart_type integer NOT NULL,
		default_widget boolean NOT NULL,
		groupbyfield character varying(255) NOT NULL,
		groupbyentity character varying(255),
		widget_idx integer NOT NULL,
		title character varying(50) NOT NULL,
		visible boolean NOT NULL,
		dashboard_id integer,
		owner_id integer NOT NULL,
		query_id integer NOT NULL
		);


		ALTER TABLE public.widget OWNER TO postgres;

		--
		-- Name: widgets_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE widgets_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.widgets_id_seq OWNER TO postgres;

		--
		-- Name: widgets_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('widgets_id_seq', 1, false);


		--
		-- Name: xfs_components; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
		--

		CREATE TABLE xfs_components (
		id integer NOT NULL,
		accept_media boolean,
		algorithms text,
		autobeep text,
		autodeposit boolean,
		autoretract_period integer,
		auxiliaries text,
		back_image_color_format text,
		backscan_color text,
		cam_data text,
		cameras text,
		can_filter_symbologies boolean,
		cards integer,
		char_support text,
		chip_power text,
		chip_protocol text,
		chip_io boolean,
		code_line_format text,
		coins boolean,
		compare_magnetic_stripe boolean,
		compound boolean,
		control text,
		cursor boolean,
		cylinders boolean,
		default_backscan_color text,
		default_frontscan_color text,
		dep_transport boolean,
		derivation_algorithms text,
		dip_mode text,
		dispense_to text,
		display text,
		display_light boolean,
		doors text,
		eject_position text,
		emv_hash_algorithm text,
		emv_import_schemes text,
		encio_protocols text,
		encode_names text,
		encoder boolean,
		endorser boolean,
		envelope_supply text,
		exchange_types text,
		extents text,
		extra text,
		font_names text,
		forms boolean,
		front_image_color_format text,
		frontscan_color text,
		guidlights text,
		has_cash_box boolean,
		has_inserted_sensor boolean,
		has_shutter boolean,
		has_taken_sensor boolean,
		hsm_vendor text,
		id_connect boolean,
		id_key text,
		image_source text,
		image_type text,
		image_capture text,
		indicators text,
		insert_orientation text,
		intermediate_stacker integer,
		is_application_refuse boolean,
		is_autofeed boolean,
		is_card_taken_sensor boolean,
		is_compare_signatures boolean,
		is_hsm_journaling boolean,
		is_intermediate_stacker boolean,
		is_items_taken_sensor boolean,
		is_key_import_through_parts boolean,
		is_media_presented boolean,
		is_pin_can_persist_after_use boolean,
		is_prepare_dispense boolean,
		is_present_control boolean,
		is_rescan boolean,
		is_retract_counts_items boolean,
		is_retract_to_transport boolean,
		is_safe_door boolean,
		is_set_pin_block_data_requited boolean,
		is_stamp boolean,
		is_type_combined boolean,
		item_info_types text,
		key_block_import_formats text,
		key_check_modes text,
		key_lock boolean,
		key_num integer,
		keys text,
		logical text,
		magnetic_stripe_read boolean,
		magnetic_stripe_write boolean,
		max_2_retract integer,
		max_bills integer,
		max_cash_in_items integer,
		max_coins integer,
		max_data_length integer,
		max_dispense_items integer,
		max_media_on_stacker integer,
		max_num_chars integer,
		max_pictures integer,
		max_retract text,
		media_taken boolean,
		memory_chip_protocols text,
		micr boolean,
		move_items text,
		multi_page boolean,
		num_leds integer,
		ocr boolean,
		output_positions text,
		paper_sources text,
		pin_formats text,
		pockets integer,
		positions text,
		power_off text,
		power_on text,
		power_save_control boolean,
		presentation_algorithms text,
		print_on_retracts boolean,
		print_size text,
		printer boolean,
		programatically_deactivate boolean,
		provider text,
		read_form text,
		read_tracks text,
		refill boolean,
		reset_control text,
		resolutions text,
		retract_areas text,
		retract_bins text,
		retract_stacker_actions text,
		retract_to_deposit boolean,
		retract_transport_actions text,
		retract_envelope text,
		rsa_auth_scheme text,
		rsa_crypt_algorithm text,
		rsa_keycheck_mode text,
		rsa_signature_algorithm text,
		security_type text,
		sensors text,
		shutter_control boolean,
		signature_scheme text,
		stamp text,
		symbologies text,
		toner boolean,
		type text,
		validation_algorithms text,
		vandal_check boolean,
		windows_printer text,
		write_form text,
		write_mode text,
		write_tracks text,
		xfs_class character varying(50) NOT NULL
		);


		ALTER TABLE public.xfs_components OWNER TO postgres;

		--
		-- Name: xfs_components_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
		--

		CREATE SEQUENCE xfs_components_id_seq
		START WITH 1
		INCREMENT BY 1
		NO MAXVALUE
		NO MINVALUE
		CACHE 1;


		ALTER TABLE public.xfs_components_id_seq OWNER TO postgres;

		--
		-- Name: xfs_components_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
		--

		SELECT pg_catalog.setval('xfs_components_id_seq', 1, false);

