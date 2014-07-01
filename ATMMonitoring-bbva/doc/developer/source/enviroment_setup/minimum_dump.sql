--
-- PostgreSQL database dump
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


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO roles (id, can_access_reports, can_edit_terminals, can_request_update, can_schedule, can_use_queries, can_view_terminals, description, manageable, name, user_manager) VALUES (2, false, true, false, false, false, false, NULL, true, 'ADMIN', false);
INSERT INTO roles (id, can_access_reports, can_edit_terminals, can_request_update, can_schedule, can_use_queries, can_view_terminals, description, manageable, name, user_manager) VALUES (1, true, true, true, true, true, true, NULL, false, 'SUPERADMIN', true);
INSERT INTO roles (id, can_access_reports, can_edit_terminals, can_request_update, can_schedule, can_use_queries, can_view_terminals, description, manageable, name, user_manager) VALUES (4, true, false, false, true, true, true, 'hhhhh', true, 'GUEST', false);
INSERT INTO roles (id, can_access_reports, can_edit_terminals, can_request_update, can_schedule, can_use_queries, can_view_terminals, description, manageable, name, user_manager) VALUES (3, true, true, true, true, true, true, '', true, 'DATA_MANAGER', false);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, firstname, last_login, lastname, passw, username, bank_id, dashboard_id, role_id) VALUES (3, 'Hermes', '2014-01-12 21:40:26.387', 'Conrad', '71315f191064d8193b5f4c78d3e03c9bad25fea855c7a590b336e1b4b377e00a536aa430fbf25a04', 'guest', NULL, NULL, 4);
INSERT INTO users (id, firstname, last_login, lastname, passw, username, bank_id, dashboard_id, role_id) VALUES (1, 'John', '2014-01-15 02:32:59.553', 'Zoidberg', '23f82a4a78f9f294b7e1d6c03101632deb47019fc21b70a7759af5739ba1300961bf32ff331e0dbd', 'admin', NULL, NULL, 1);
INSERT INTO users (id, firstname, last_login, lastname, passw, username, bank_id, dashboard_id, role_id) VALUES (2, 'Hubert', '2014-01-13 02:10:34.511', 'Farnsworth', '26425264edfe9205de96d6ca39cb3b5cc6aa3e2ebb5a29df1134757bb81e4509987507a3614c76db', 'data', NULL, NULL, 3);


--
-- Name: auditable_internet_explorer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY auditable_internet_explorer
    ADD CONSTRAINT auditable_internet_explorer_pkey PRIMARY KEY (id);


--
-- Name: bank_companies_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bank_companies
    ADD CONSTRAINT bank_companies_name_key UNIQUE (name);


--
-- Name: bank_companies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bank_companies
    ADD CONSTRAINT bank_companies_pkey PRIMARY KEY (id);


--
-- Name: bank_companies_vat_in_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bank_companies
    ADD CONSTRAINT bank_companies_vat_in_key UNIQUE (vat_in);


--
-- Name: dashboard_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dashboard
    ADD CONSTRAINT dashboard_pkey PRIMARY KEY (id);


--
-- Name: financial_device_jxfs_component_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY financial_device_jxfs_component
    ADD CONSTRAINT financial_device_jxfs_component_pkey PRIMARY KEY (financial_device_id, jxfs_component_id);


--
-- Name: financial_device_xfs_component_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY financial_device_xfs_component
    ADD CONSTRAINT financial_device_xfs_component_pkey PRIMARY KEY (financial_device_id, xfs_component_id);


--
-- Name: financial_devices_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY financial_devices
    ADD CONSTRAINT financial_devices_pkey PRIMARY KEY (id);


--
-- Name: hardware_devices_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY hardware_devices
    ADD CONSTRAINT hardware_devices_pkey PRIMARY KEY (id);


--
-- Name: hotfixes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY hotfixes
    ADD CONSTRAINT hotfixes_pkey PRIMARY KEY (id);


--
-- Name: installations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY installations
    ADD CONSTRAINT installations_pkey PRIMARY KEY (id);


--
-- Name: internet_explorers_major_version_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY internet_explorers
    ADD CONSTRAINT internet_explorers_major_version_key UNIQUE (major_version, minor_version, build_version, revision_version, remaining_version);


--
-- Name: internet_explorers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY internet_explorers
    ADD CONSTRAINT internet_explorers_pkey PRIMARY KEY (id);


--
-- Name: jxfs_components_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY jxfs_components
    ADD CONSTRAINT jxfs_components_pkey PRIMARY KEY (id);


--
-- Name: locations_address_street_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY locations
    ADD CONSTRAINT locations_address_street_key UNIQUE (address_street, address_number, address_city, address_postcode, address_country);


--
-- Name: locations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY locations
    ADD CONSTRAINT locations_pkey PRIMARY KEY (id);


--
-- Name: logical_cash_units_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY logical_cash_units
    ADD CONSTRAINT logical_cash_units_pkey PRIMARY KEY (id);


--
-- Name: operating_systems_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY operating_systems
    ADD CONSTRAINT operating_systems_pkey PRIMARY KEY (id);


--
-- Name: operating_systems_serial_number_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY operating_systems
    ADD CONSTRAINT operating_systems_serial_number_key UNIQUE (serial_number);


--
-- Name: physical_cash_units_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY physical_cash_units
    ADD CONSTRAINT physical_cash_units_pkey PRIMARY KEY (id);


--
-- Name: queries_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY queries
    ADD CONSTRAINT queries_pkey PRIMARY KEY (id);


--
-- Name: roles_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_name_key UNIQUE (name);


--
-- Name: roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: scheduled_updates_month_day_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY scheduled_updates
    ADD CONSTRAINT scheduled_updates_month_day_key UNIQUE (month_day, hours, minutes);


--
-- Name: scheduled_updates_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY scheduled_updates
    ADD CONSTRAINT scheduled_updates_pkey PRIMARY KEY (id);


--
-- Name: scheduled_updates_week_day_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY scheduled_updates
    ADD CONSTRAINT scheduled_updates_week_day_key UNIQUE (week_day, hours, minutes);


--
-- Name: software_aggregates_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY software_aggregates
    ADD CONSTRAINT software_aggregates_name_key UNIQUE (name, major_version, minor_version, build_version, revision_version, remaining_version);


--
-- Name: software_aggregates_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY software_aggregates
    ADD CONSTRAINT software_aggregates_pkey PRIMARY KEY (id);


--
-- Name: software_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY software
    ADD CONSTRAINT software_pkey PRIMARY KEY (id);


--
-- Name: t_config_op_system_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY t_config_op_system
    ADD CONSTRAINT t_config_op_system_pkey PRIMARY KEY (terminal_config_id, operating_system_id);


--
-- Name: terminal_auditable_internet_explorer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminal_auditable_internet_explorer
    ADD CONSTRAINT terminal_auditable_internet_explorer_pkey PRIMARY KEY (terminal_id, auditable_internet_explorer_id);


--
-- Name: terminal_config_software_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminal_config_software
    ADD CONSTRAINT terminal_config_software_pkey PRIMARY KEY (terminal_config_id, software_id);


--
-- Name: terminal_configs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminal_configs
    ADD CONSTRAINT terminal_configs_pkey PRIMARY KEY (id);


--
-- Name: terminal_configs_terminal_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminal_configs
    ADD CONSTRAINT terminal_configs_terminal_id_key UNIQUE (terminal_id, start_date);


--
-- Name: terminal_models_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminal_models
    ADD CONSTRAINT terminal_models_pkey PRIMARY KEY (id);


--
-- Name: terminal_models_product_class_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminal_models
    ADD CONSTRAINT terminal_models_product_class_key UNIQUE (product_class);


--
-- Name: terminal_software_aggregate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminal_software_aggregate
    ADD CONSTRAINT terminal_software_aggregate_pkey PRIMARY KEY (terminal_id, software_aggregate_id);


--
-- Name: terminals_installations_installations_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminals_installations
    ADD CONSTRAINT terminals_installations_installations_id_key UNIQUE (installations_id);


--
-- Name: terminals_installations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminals_installations
    ADD CONSTRAINT terminals_installations_pkey PRIMARY KEY (terminals_id, installations_id);


--
-- Name: terminals_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminals
    ADD CONSTRAINT terminals_pkey PRIMARY KEY (id);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: users_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- Name: widget_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY widget
    ADD CONSTRAINT widget_pkey PRIMARY KEY (id);


--
-- Name: xfs_components_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY xfs_components
    ADD CONSTRAINT xfs_components_pkey PRIMARY KEY (id);


--
-- Name: vatinindex; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX vatinindex ON bank_companies USING btree (vat_in);


--
-- Name: fk16706a30a2cc8c9c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_auditable_internet_explorer
    ADD CONSTRAINT fk16706a30a2cc8c9c FOREIGN KEY (auditable_internet_explorer_id) REFERENCES auditable_internet_explorer(id);


--
-- Name: fk16706a30b5904f7a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_auditable_internet_explorer
    ADD CONSTRAINT fk16706a30b5904f7a FOREIGN KEY (terminal_id) REFERENCES terminals(id);


--
-- Name: fk1e271450269714cf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY financial_device_xfs_component
    ADD CONSTRAINT fk1e271450269714cf FOREIGN KEY (xfs_component_id) REFERENCES xfs_components(id);


--
-- Name: fk1e2714502be1606d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY financial_device_xfs_component
    ADD CONSTRAINT fk1e2714502be1606d FOREIGN KEY (financial_device_id) REFERENCES financial_devices(id);


--
-- Name: fk24c36d736c453afd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY auditable_internet_explorer
    ADD CONSTRAINT fk24c36d736c453afd FOREIGN KEY (internet_explorer_id) REFERENCES internet_explorers(id);


--
-- Name: fk270bd7661c0b391a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY queries
    ADD CONSTRAINT fk270bd7661c0b391a FOREIGN KEY (user_id) REFERENCES users(id);


--
-- Name: fk280eddfb50043553; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY t_config_op_system
    ADD CONSTRAINT fk280eddfb50043553 FOREIGN KEY (terminal_config_id) REFERENCES terminal_configs(id);


--
-- Name: fk280eddfb9060273d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY t_config_op_system
    ADD CONSTRAINT fk280eddfb9060273d FOREIGN KEY (operating_system_id) REFERENCES operating_systems(id);


--
-- Name: fk32e0cd59269714cf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY logical_cash_units
    ADD CONSTRAINT fk32e0cd59269714cf FOREIGN KEY (xfs_component_id) REFERENCES xfs_components(id);


--
-- Name: fk369ffca948b67cb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_software_aggregate
    ADD CONSTRAINT fk369ffca948b67cb FOREIGN KEY (software_aggregate_id) REFERENCES software_aggregates(id);


--
-- Name: fk369ffcab5904f7a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_software_aggregate
    ADD CONSTRAINT fk369ffcab5904f7a FOREIGN KEY (terminal_id) REFERENCES terminals(id);


--
-- Name: fk3f180a4150043553; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_config_software
    ADD CONSTRAINT fk3f180a4150043553 FOREIGN KEY (terminal_config_id) REFERENCES terminal_configs(id);


--
-- Name: fk3f180a41f3dd7b9a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_config_software
    ADD CONSTRAINT fk3f180a41f3dd7b9a FOREIGN KEY (software_id) REFERENCES software(id);


--
-- Name: fk5bd69cb14e76fe9f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminals_installations
    ADD CONSTRAINT fk5bd69cb14e76fe9f FOREIGN KEY (terminals_id) REFERENCES terminals(id);


--
-- Name: fk5bd69cb19648e71b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminals_installations
    ADD CONSTRAINT fk5bd69cb19648e71b FOREIGN KEY (installations_id) REFERENCES installations(id);


--
-- Name: fk5f814b382f77e57a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scheduled_updates
    ADD CONSTRAINT fk5f814b382f77e57a FOREIGN KEY (query_id) REFERENCES queries(id);


--
-- Name: fk67db9727b5904f7a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY financial_devices
    ADD CONSTRAINT fk67db9727b5904f7a FOREIGN KEY (terminal_id) REFERENCES terminals(id);


--
-- Name: fk6a68e0876e0753a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT fk6a68e0876e0753a FOREIGN KEY (role_id) REFERENCES roles(id);


--
-- Name: fk6a68e08e304a1fa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT fk6a68e08e304a1fa FOREIGN KEY (dashboard_id) REFERENCES dashboard(id);


--
-- Name: fk6a68e08ece77d5f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT fk6a68e08ece77d5f FOREIGN KEY (bank_id) REFERENCES bank_companies(id);


--
-- Name: fk795abd772a1a5321; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminals
    ADD CONSTRAINT fk795abd772a1a5321 FOREIGN KEY (terminal_model_id) REFERENCES terminal_models(id);


--
-- Name: fk795abd77ece77d5f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminals
    ADD CONSTRAINT fk795abd77ece77d5f FOREIGN KEY (bank_id) REFERENCES bank_companies(id);


--
-- Name: fk9ecfd186b5904f7a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hardware_devices
    ADD CONSTRAINT fk9ecfd186b5904f7a FOREIGN KEY (terminal_id) REFERENCES terminals(id);


--
-- Name: fkb383479848ca2d49; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bank_companies
    ADD CONSTRAINT fkb383479848ca2d49 FOREIGN KEY (parent_company) REFERENCES bank_companies(id);


--
-- Name: fkb43e69799318da; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY installations
    ADD CONSTRAINT fkb43e69799318da FOREIGN KEY (location_id) REFERENCES locations(id);


--
-- Name: fkbe250a2c2be1606d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY financial_device_jxfs_component
    ADD CONSTRAINT fkbe250a2c2be1606d FOREIGN KEY (financial_device_id) REFERENCES financial_devices(id);


--
-- Name: fkbe250a2ca8255c23; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY financial_device_jxfs_component
    ADD CONSTRAINT fkbe250a2ca8255c23 FOREIGN KEY (jxfs_component_id) REFERENCES jxfs_components(id);


--
-- Name: fkd04be2aeb5904f7a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_configs
    ADD CONSTRAINT fkd04be2aeb5904f7a FOREIGN KEY (terminal_id) REFERENCES terminals(id);


--
-- Name: fkd1075a442f77e57a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY widget
    ADD CONSTRAINT fkd1075a442f77e57a FOREIGN KEY (query_id) REFERENCES queries(id);


--
-- Name: fkd1075a4487f1e932; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY widget
    ADD CONSTRAINT fkd1075a4487f1e932 FOREIGN KEY (owner_id) REFERENCES users(id);


--
-- Name: fkd1075a44e304a1fa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY widget
    ADD CONSTRAINT fkd1075a44e304a1fa FOREIGN KEY (dashboard_id) REFERENCES dashboard(id);


--
-- Name: fkd49d1bcbb52f1460; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY physical_cash_units
    ADD CONSTRAINT fkd49d1bcbb52f1460 FOREIGN KEY (logical_cash_unit_id) REFERENCES logical_cash_units(id);


--
-- Name: fkef0efb56b5904f7a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hotfixes
    ADD CONSTRAINT fkef0efb56b5904f7a FOREIGN KEY (terminal_id) REFERENCES terminals(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

