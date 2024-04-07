alter table bi_service add column service_type varchar(255);
alter table bi_service add column service_module varchar(255);
INSERT INTO public.bi_service (product_category, service_category, "name", status, created_on, created_by, service_type, service_module) VALUES('SOA', 'APP', 'Java Spring Boot Api Server', 'ACTIVE', current_timestamp, 'System', 'COMMON', 'SEARCH');
INSERT INTO public.bi_service (product_category, service_category, "name", status, created_on, created_by, service_type, service_module) VALUES('SOA', 'DATA', 'Postgresql', 'ACTIVE', current_timestamp, 'System', 'COMMON', 'SEARCH');
INSERT INTO public.bi_service (product_category, service_category, "name", status, created_on, created_by, service_type, service_module) VALUES('SOA', 'OTHER', 'Ealsticsearch', 'ACTIVE', current_timestamp, 'System', 'COMMON', 'SEARCH');
INSERT INTO public.bi_service (product_category, service_category, "name", status, created_on, created_by, service_type, service_module) VALUES('SOA', 'PERIPHERAL', 'WAF', 'ACTIVE', current_timestamp, 'System', 'COMMON', 'SEARCH');
INSERT INTO public.bi_service (product_category, service_category, "name", status, created_on, created_by, service_type, service_module) VALUES('SOA', 'PERIPHERAL', 'API Gw', 'ACTIVE', current_timestamp, 'System', 'COMMON', 'SEARCH');
INSERT INTO public.bi_service (product_category, service_category, "name", status, created_on, created_by, service_type, service_module) VALUES('SOA', 'PERIPHERAL', 'Load Balancer', 'ACTIVE', current_timestamp, 'System', 'COMMON', 'SEARCH');
INSERT INTO public.bi_service (product_category, service_category, "name", status, created_on, created_by, service_type, service_module) VALUES('SOA', 'APP', 'Java Spring Boot Api Server', 'ACTIVE', current_timestamp, 'System', 'COMMON', 'SECURITY');
INSERT INTO public.bi_service (product_category, service_category, "name", status, created_on, created_by, service_type, service_module) VALUES('SOA', 'DATA', 'Postgresql', 'ACTIVE', current_timestamp, 'System', 'COMMON', 'SECURITY');
INSERT INTO public.bi_service (product_category, service_category, "name", status, created_on, created_by, service_type, service_module) VALUES('SOA', 'OTHER', 'Ealsticsearch', 'ACTIVE', current_timestamp, 'System', 'COMMON', 'SECURITY');
INSERT INTO public.bi_service (product_category, service_category, "name", status, created_on, created_by, service_type, service_module) VALUES('SOA', 'PERIPHERAL', 'WAF', 'ACTIVE', current_timestamp, 'System', 'COMMON', 'SECURITY');
INSERT INTO public.bi_service (product_category, service_category, "name", status, created_on, created_by, service_type, service_module) VALUES('SOA', 'PERIPHERAL', 'API Gw', 'ACTIVE', current_timestamp, 'System', 'COMMON', 'SECURITY');
INSERT INTO public.bi_service (product_category, service_category, "name", status, created_on, created_by, service_type, service_module) VALUES('SOA', 'PERIPHERAL', 'Load Balancer', 'ACTIVE', current_timestamp, 'System', 'COMMON', 'SECURITY');