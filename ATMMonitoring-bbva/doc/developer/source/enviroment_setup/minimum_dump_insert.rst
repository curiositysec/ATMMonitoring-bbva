.. code-block:: sql

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

