--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.3

-- Started on 2017-11-27 14:47:58

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 16648)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cliente (
    c_nom character varying(30) NOT NULL,
    dir character varying(100) NOT NULL,
    tel character varying(20) NOT NULL,
    tipo character(1) NOT NULL,
    zona character(1) NOT NULL,
    deuda double precision NOT NULL,
    baja boolean NOT NULL,
    indice integer NOT NULL
);


ALTER TABLE cliente OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 16678)
-- Name: factura; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE factura (
    r_nro integer NOT NULL,
    f_fecha character varying(10) NOT NULL
);


ALTER TABLE factura OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 16668)
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pedido (
    r_nro integer NOT NULL,
    p_cod character varying(8) NOT NULL,
    cant double precision NOT NULL,
    unid character(1) NOT NULL,
    precio real NOT NULL
);


ALTER TABLE pedido OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 16653)
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE producto (
    p_cod character varying(8) NOT NULL,
    p_nom character varying(30) NOT NULL,
    precio_k double precision NOT NULL,
    precio_d double precision NOT NULL,
    precio_u double precision NOT NULL,
    precio_predeterminado character(1) NOT NULL
);


ALTER TABLE producto OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 24855)
-- Name: remito_r_nro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE remito_r_nro_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE remito_r_nro_seq OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16658)
-- Name: remito; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE remito (
    r_nro integer DEFAULT nextval('remito_r_nro_seq'::regclass) NOT NULL,
    c_nom character varying(30) NOT NULL,
    fecha character(10) NOT NULL,
    p_total double precision NOT NULL,
    p_abonado double precision NOT NULL,
    deuda_actual double precision NOT NULL,
    cancel boolean NOT NULL,
    turno character(1) NOT NULL
);


ALTER TABLE remito OWNER TO postgres;

--
-- TOC entry 2148 (class 0 OID 16648)
-- Dependencies: 185
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cliente (c_nom, dir, tel, tipo, zona, deuda, baja, indice) FROM stdin;
Agus	_	_	F	A	0	f	6
Laura	_	_	F	A	0	f	7
Gauchito	_	_	F	A	0	f	8
Garce	_	_	F	A	0	f	9
Adrian	_	_	F	A	0	f	10
Jorge	_	_	F	A	0	f	11
Perez	_	_	F	A	0	f	12
S.Corazon	_	_	F	A	0	f	13
Dalu	_	_	F	A	0	f	14
Nico	_	_	F	A	0	f	15
Danydan	_	_	F	A	0	f	16
F.Pastas	_	_	F	A	0	f	17
F.Brasas	_	_	F	A	0	f	18
Monica	_	_	F	B	0	f	19
Victoria	_	_	F	B	0	f	20
Iglesia	_	_	F	B	0	f	21
Mirtha	_	_	F	B	0	f	22
Las Marias	_	_	F	B	0	f	24
La Familia	_	_	F	B	0	f	25
Alex	_	_	F	B	0	f	26
El Sol	_	_	F	B	0	f	27
Fabian	_	_	F	C	0	f	28
Valentini	_	_	F	C	0	f	29
La Pampa	_	_	F	C	0	f	30
Busto	_	_	F	D	0	f	31
Antonio	_	_	F	D	0	f	32
Ignacio	_	_	F	D	0	f	33
Tambaleo	_	_	F	D	0	f	34
Facundo	_	_	F	D	0	f	35
Lorsani	_	_	F	D	0	f	36
Melisa	_	_	F	D	0	f	37
Luciano 1	_	_	F	D	0	f	38
Luciano 2	_	_	F	D	0	f	39
Churrero	_	_	F	D	0	f	40
Omar	_	_	F	D	0	f	41
Frutilla	_	_	F	D	0	f	42
Mariela	_	_	F	D	0	f	43
Nene	_	_	F	D	0	f	44
Carlos	_	_	F	A	0	f	0
Carrizo	_	_	F	A	0	f	1
Pippo	_	_	F	A	0	f	2
Liliana	_	_	F	A	0	f	3
Betina	_	_	F	A	0	f	4
Jorge Sur	_	_	F	A	0	f	5
La Loma	_	_	F	B	0	f	23
\.


--
-- TOC entry 2152 (class 0 OID 16678)
-- Dependencies: 189
-- Data for Name: factura; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY factura (r_nro, f_fecha) FROM stdin;
\.


--
-- TOC entry 2151 (class 0 OID 16668)
-- Dependencies: 188
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pedido (r_nro, p_cod, cant, unid, precio) FROM stdin;
\.


--
-- TOC entry 2149 (class 0 OID 16653)
-- Dependencies: 186
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY producto (p_cod, p_nom, precio_k, precio_d, precio_u, precio_predeterminado) FROM stdin;
8	Baguette fina	0	0	9	u
9	Baguette gruesa	0	0	12	u
88	Saludables	120	0	0	k
21	Cremonas	80	0	0	k
18	Cuernitos	40	0	0	k
133	Harina	10	0	0	k
134	Levadura	120	0	0	k
22	Marineras Varias	80	0	0	k
15	Pan de chips	90	0	0	k
16	Pan de figasa comun	75	0	0	k
17	Pan de figasa especial	90	0	0	k
12	Pan de lomo	0	0	12	u
11	Pan casero	0	0	25	u
268	Pan florcita	50	0	0	k
10	Pan rallado	36	0	0	k
240	Pan saludable	0	0	20	u
2	Pan trabuco	0	0	5	u
255	Pebetes	0	0	6	u
211	Pizza salvado	0	0	14	u
267	Pizzetitas	80	0	0	k
256	Pre-pizza 60x40	0	0	40	u
25	Pre-pizza cebolla	0	0	16	u
27	Pre-pizza doble	0	0	26	u
26	Pre-pizza simple	0	0	13	u
241	Super pancho	0	0	7.5	u
20	Tortas pinchadas	0	0	3.75	u
19	Tortas raspadas	0	0	3.75	u
23	Tostadas de gluten	120	0	0	k
\.


--
-- TOC entry 2150 (class 0 OID 16658)
-- Dependencies: 187
-- Data for Name: remito; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY remito (r_nro, c_nom, fecha, p_total, p_abonado, deuda_actual, cancel, turno) FROM stdin;
\.


--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 190
-- Name: remito_r_nro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('remito_r_nro_seq', 18, true);


--
-- TOC entry 2019 (class 2606 OID 16652)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (c_nom);


--
-- TOC entry 2027 (class 2606 OID 16682)
-- Name: factura factura_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY factura
    ADD CONSTRAINT factura_pkey PRIMARY KEY (r_nro);


--
-- TOC entry 2025 (class 2606 OID 16672)
-- Name: pedido pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (r_nro, p_cod);


--
-- TOC entry 2021 (class 2606 OID 16657)
-- Name: producto producto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (p_cod);


--
-- TOC entry 2023 (class 2606 OID 16662)
-- Name: remito remito_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY remito
    ADD CONSTRAINT remito_pkey PRIMARY KEY (r_nro);


--
-- TOC entry 2030 (class 2606 OID 16683)
-- Name: factura factura_r_nro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY factura
    ADD CONSTRAINT factura_r_nro_fkey FOREIGN KEY (r_nro) REFERENCES remito(r_nro);


--
-- TOC entry 2029 (class 2606 OID 16673)
-- Name: pedido pedido_r_nro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_r_nro_fkey FOREIGN KEY (r_nro) REFERENCES remito(r_nro);


--
-- TOC entry 2028 (class 2606 OID 16663)
-- Name: remito remito_c_nom_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY remito
    ADD CONSTRAINT remito_c_nom_fkey FOREIGN KEY (c_nom) REFERENCES cliente(c_nom);


-- Completed on 2017-11-27 14:47:59

--
-- PostgreSQL database dump complete
--

