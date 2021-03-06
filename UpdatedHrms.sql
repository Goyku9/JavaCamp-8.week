

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;



CREATE TABLE public.staffers (
    user_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL
);


ALTER TABLE public.staffers OWNER TO postgres;



CREATE TABLE public.employers (
    user_id integer NOT NULL,
    website character varying(250) NOT NULL,
    phone_number character varying(30) NOT NULL,
    is_verified boolean NOT NULL,
    company_name character varying(250) NOT NULL
);


ALTER TABLE public.employers OWNER TO postgres;



CREATE TABLE public.authentication_codes (
    id integer NOT NULL,
    user_id integer NOT NULL,
    code character varying(50) NOT NULL,
    is_confirmed boolean NOT NULL,
    created_at date NOT NULL
);


ALTER TABLE public.authentication_codes OWNER TO postgres;



ALTER TABLE public.authentication_codes ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.employers_authentication_codes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);




CREATE TABLE public.employers_authentication_staffers (
    id integer NOT NULL,
    employer_id integer NOT NULL,
    staffer_id integer NOT NULL,
    created_at date DEFAULT CURRENT_DATE NOT NULL
);


ALTER TABLE public.employers_authentication_staffers OWNER TO postgres;



ALTER TABLE public.employers_authentication_staffers ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.employers_authentication_staffers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);




CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;


CREATE TABLE public.positions (
    id integer NOT NULL,
    position_name character varying(150) NOT NULL,
    created_date date,
    is_actived boolean,
    is_deleted boolean
);


ALTER TABLE public.positions OWNER TO postgres;



ALTER TABLE public.positions ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.positions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);



CREATE TABLE public.jobHunters (
    user_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    national_id character varying(11) NOT NULL,
    is_verified boolean NOT NULL,
    date_of_birth date NOT NULL
);


ALTER TABLE public.jobHunters OWNER TO postgres;



CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(100) NOT NULL,
    password character varying(30) NOT NULL,
    created_at date,
    is_active boolean,
    is_deleted boolean
);


ALTER TABLE public.users OWNER TO postgres;



ALTER TABLE public.users ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);




ALTER TABLE ONLY public.staffers
    ADD CONSTRAINT staffers_pkey PRIMARY KEY (user_id);




ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_pkey PRIMARY KEY (user_id);




ALTER TABLE ONLY public.authentication_codes
    ADD CONSTRAINT employers_authentication_codes_pkey PRIMARY KEY (id);




ALTER TABLE ONLY public.employers_authentication_staffers
    ADD CONSTRAINT employers_authentication_staffers_pkey PRIMARY KEY (id);




ALTER TABLE ONLY public.positions
    ADD CONSTRAINT positions_pkey PRIMARY KEY (id);





ALTER TABLE ONLY public.jobHunters
    ADD CONSTRAINT jobHunters_national_id_key UNIQUE (national_id) INCLUDE (national_id);




ALTER TABLE ONLY public.jobHunters
    ADD CONSTRAINT jobHunters_pkey PRIMARY KEY (user_id);




ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email) INCLUDE (email);




ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);




ALTER TABLE ONLY public.employers_authentication_staffers
    ADD CONSTRAINT staffer_id FOREIGN KEY (staffer_id) REFERENCES public.staffers(user_id) NOT VALID;



ALTER TABLE ONLY public.employers_authentication_staffers
    ADD CONSTRAINT employer_id FOREIGN KEY (employer_id) REFERENCES public.employers(user_id) NOT VALID;




ALTER TABLE ONLY public.employers
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;




ALTER TABLE ONLY public.jobHunters
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;




ALTER TABLE ONLY public.staffers
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;




ALTER TABLE ONLY public.authentication_codes
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


