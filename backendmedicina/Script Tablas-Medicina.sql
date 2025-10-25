CREATE TABLE medicina.tbl_historia_Clinica (
	id_historia_clinica int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	id_empleado int4 NOT NULL,
	id_signo_vital int4 NOT NULL,
	id_historia_psico int4 NOT NULL,
	id_certificado int4 NOT NULL,
	id_tipo_antecedente INT NOT NULL,
	id_inmunizaciones int4 NOT NULL,
	id_evaluaciones INT NOT NULL,
	id_evaluacion_preocupacional int4 NOT NULL,
	id_evaluacion_periodica int4 NOT NULL,
	id_evaluacion_reintegro int4 NOT NULL,
	id_evaluacion_retiro int4 NOT NULL,
	tipo text NULL,
	observaciones text NULL,
	fecha_inicio date NULL,
    numero_historia_clinica varchar(20),
	antecedente_familiar text NULL,
	alergias text NULL,
	CONSTRAINT tbl_historia_clinica_pk PRIMARY KEY (id_historia_clinica)
);

CREATE TABLE medicina.tbl_cita_medica (
id_cita_medica serial4 NOT NULL,
	id_empleado int4 NOT NULL,
	id_historia int4 NOT NULL,
	id_signo_vital int4 NOT NULL,
	id_usuario int4 NOT NULL,
	id_departamento int4 NOT NULL,
	id_atencion_psico int4 NOT NULL,
	fecha_cita date NULL,
	hora_cita time NULL,
	observacion text NULL,
	CONSTRAINT tbl_cita_medica_pk PRIMARY KEY (id_cita_medica)
);

CREATE TABLE medicina.tbl_usuario (
id_usuario serial4 NOT NULL,
id_evaluaciones INT NOT NULL,
	id_empleado int4 NOT NULL,
	id_cita_medica int4 NOT NULL,
	nombre text NULL,
	rol text NULL,
	contraseña varchar(40) NULL,
	CONSTRAINT tbl_usuario_pk PRIMARY KEY (id_usuario)
);

CREATE TABLE medicina.tbl_inmunizaciones (
id_inmunizacion serial4 NOT NULL,
	id_empleado int4 NOT NULL,
	id_historia_clinica int4 NOT NULL,
	id_usuario int4 NOT NULL,
	fecha date NULL,
	lote text NULL,
	nombre text NULL,
	dosis varchar(25) NULL,
	CONSTRAINT tbl_inmunizacion_pk PRIMARY KEY (id_inmunizacion)
);

CREATE TABLE medicina.tbl_examen_fisico (
    id_examen_fisico SERIAL PRIMARY KEY,
    id_empleado INT NOT NULL,
    tipo VARCHAR(50),
    resultados TEXT,
    -- 1. Piel
    cicatrices BOOLEAN,
    tatuajes BOOLEAN,
    piel_faneras TEXT,
    -- 2. Ojos
    parpados TEXT,
    conjuntivas TEXT,
    pupilas TEXT,
    cornea TEXT,
    motilidad_ocular TEXT,
    -- 3. Oído
    conducto_auditivo_externo TEXT,
    pabellon TEXT,
    timpanos TEXT,
    -- 4. Orofaringe
    labios TEXT,
    lengua TEXT,
    faringe TEXT,
    amigdalas TEXT,
    dentadura TEXT,
    -- 5. Nariz
    tabique TEXT,
    cornetes TEXT,
    mucosas TEXT,
    senos_paranasales TEXT,
    -- 6. Cuello
    tiroides_masas TEXT,
    movilidad_cuello TEXT,
    -- 7. Tórax
    mamas TEXT,
    corazon TEXT,
    -- 8. Tórax (Respiratorio)
    pulmones TEXT,
    parrilla_costal TEXT,
    -- 9. Abdomen
    visceras TEXT,
    pared_abdominal TEXT,
    -- 10. Columna
    flexibilidad TEXT,
    desviacion TEXT,
    dolor TEXT,
    -- 11. Pelvis
    pelvis TEXT,
    genitales TEXT,
    -- 12. Extremidades
    vascular TEXT,
    miembros_superiores TEXT,
    miembros_inferiores TEXT,
    -- 13. Neurológico
    fuerza TEXT,
    sensibilidad TEXT,
    marcha TEXT,
    reflejos TEXT,
    observaciones TEXT
);

CREATE TABLE medicina.tbl_atencion_seguimiento_psicosocial (
    id_atencion_psicosocial serial4 NOT NULL,
    id_historia_psicologica INT NOT NULL,
    id_empleado INT NOT NULL,
    id_usuario INT NOT NULL,
    id_evaluaciones INT NOT NULL,
    id_tipo_antecedente INT NOT NULL,
    modalidad VARCHAR(50) NOT NULL,
    psicopatologia TEXT,
    sesion INT NOT NULL,
    consumo TEXT,
    riesgo_social TEXT,
    fecha_hora TIMESTAMP DEFAULT now() NOT NULL,
    temas_tratados TEXT,
    reactivos TEXT,
    resultados TEXT,
    herramientas TEXT,
    avances TEXT,
    seguimiento_social TEXT,
    familiar_contactado BOOLEAN DEFAULT false,
    telefono VARCHAR(15),
    nombres VARCHAR(100),
    version_hechos TEXT,
    verificadores_del_seguimiento TEXT,
    firma_psico BYTEA,
    firma_paciente BYTEA,
    CONSTRAINT tbl_atencion_seguimiento_psicosocial_pk PRIMARY KEY (id_atencion_psicosocial)
    );

CREATE TABLE medicina.tbl_historia_clinica_psicologica (
    id_historia_psicologica serial4 NOT NULL,
    id_historia INT NOT NULL,
    id_usuario INT NOT NULL,
    id_atencion_psicologica INT NOT NULL,
    id_empleado INT NOT NULL,
    id_tipo_antecedente INT NOT NULL,
    motivo_consulta TEXT NOT NULL,
    observacion_general TEXT,
    aspectos TEXT,
    historias_situacion TEXT,
    intentos_solucion TEXT,
    nombre_apoyo VARCHAR(100),
    parentesco VARCHAR(50),
    CONSTRAINT tbl_historia_clinica_psicologica_pk PRIMARY KEY (id_historia_psicologica)
);

CREATE TABLE medicina.tbl_habitos_toxicos (
    id_habito_toxico serial4 NOT NULL,
    id_atencion_psicosocial INT NOT NULL,
    id_historia_psicologica INT NOT NULL,
    tipo VARCHAR(100) NOT NULL,
    frecuencia VARCHAR(50),
    cantidad VARCHAR(50),
    observaciones TEXT,
    CONSTRAINT tbl_habitos_toxicos_pk PRIMARY KEY (id_habito_toxico)
);

CREATE TABLE medicina.tbl_estilo_vida (
    id_estilo_vida serial4 NOT NULL,
    id_atencion_psicosocial INT NOT NULL,
    id_historia_psicologica INT NOT NULL,
    id_historia_clinica INT NOT NULL,
    actividad_fisica VARCHAR(100),
    alimentacion TEXT,
    horas_sueno INT,
    uso_tiempo_libre TEXT,
    estres TEXT,
    observaciones TEXT,
    CONSTRAINT tbl_estilo_vida_pk PRIMARY KEY (id_estilo_vida)
);

CREATE TABLE medicina.tbl_categorias_factores_riesgo (
    id_categoria_factor_riesgo serial4 NOT NULL,
    id_historia_psicologica INT NOT NULL,
    id_historia_clinica INT NOT NULL,
    id_empleado INT NOT NULL,
    id_usuario INT NOT NULL,
    id_evaluaciones INT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    CONSTRAINT tbl_categorias_factores_riesgo_pk PRIMARY KEY (id_categoria_factor_riesgo)
);

CREATE TABLE medicina.tbl_factores_riesgo (
    id_factor_riesgo serial4 NOT NULL,
    id_categoria_factor_riesgo INT NOT NULL,
    id_atencion_psicosocial INT NOT NULL,
    descripcion TEXT NOT NULL,
    nivel_riesgo VARCHAR(50),  -- Bajo, Medio, Alto
    observaciones TEXT,
    CONSTRAINT tbl_factores_riesgo_pk PRIMARY KEY (id_factor_riesgo)
 );

CREATE TABLE medicina.tbl_tipo_antecedente (
    id_tipo_antecedente serial4 NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    CONSTRAINT tbl_tipo_antecedente_pk PRIMARY KEY (id_tipo_antecedente)
);

CREATE TABLE medicina.tbl_antecedentes (
    id_antecedente serial4 NOT NULL,
    id_evaluacion INT NOT NULL,
    id_tipo_antecedente INT NOT NULL,
    descripcion TEXT NOT NULL,
    CONSTRAINT tbl_antecedentes_pk PRIMARY KEY (id_antecedente)
);

CREATE TABLE medicina.tbl_actitud_medica (
    id_actitud_medica serial4 NOT NULL,
    actitud TEXT NOT NULL,
    observacion TEXT,
    limitacion TEXT,
    CONSTRAINT tbl_actitud_medica_pk PRIMARY KEY (id_actitud_medica)
);

CREATE TABLE medicina.tbl_reportes (
    id_reporte serial4 NOT NULL,
    id_usuario INT NOT NULL,
    fecha_generacion TIMESTAMP DEFAULT now(),
    detalles TEXT,
    CONSTRAINT tbl_reportes_pk PRIMARY KEY (id_reporte)
);

CREATE TABLE medicina.tbl_evaluaciones (
    id_evaluacion serial4 NOT NULL,
    id_empleado INT NOT NULL,
    tipo_evaluacion VARCHAR(50) NOT NULL, -- (Ej: Periódica, Ocupacional, Retiro, etc.)
    fecha DATE NOT NULL DEFAULT now(),
    resultado TEXT,
    id_usuario INT NOT NULL,
    CONSTRAINT tbl_evaluaciones_pk PRIMARY KEY (id_evaluacion)
);

CREATE TABLE medicina.tbl_evaluacion_preocupacional (
    id_evaluacion_preocupacional serial4 NOT NULL,
    id_historia INT NOT NULL,
    motivo_consulta TEXT,
    antecedentes TEXT,
    examen_fisico TEXT,
    CONSTRAINT tbl_evaluacion_preocupacional_pk PRIMARY KEY (id_evaluacion_preocupacional)
);

CREATE TABLE medicina.tbl_evaluacion_periodica (
    id_evaluacion_periodica serial4 NOT NULL,
    id_empleado INT NOT NULL,
    id_usuario INT NOT NULL,
    fecha DATE NOT NULL DEFAULT now(),
    motivo TEXT,
    observaciones TEXT,
    resultado TEXT,
    diagnostico TEXT,
    CONSTRAINT tbl_evaluacion_periodica_pk PRIMARY KEY (id_evaluacion_periodica)
);

CREATE TABLE medicina.tbl_evaluacion_reintegro (
    id_evaluacion_reintegro serial4 NOT NULL,
    fecha_reintegro DATE NOT NULL,
    causas_salida TEXT,
    motivo TEXT,
    enfermedad_actual TEXT,
    ambito TEXT,
    CONSTRAINT tbl_evaluacion_reintegro_pk PRIMARY KEY (id_evaluacion_reintegro)
);

CREATE TABLE medicina.tbl_evaluacion_retiro (
    id_evaluacion_retiro serial4 NOT NULL,
    id_empleado INT NOT NULL,
    observaciones TEXT,
    recomendaciones TEXT,
    accidentes TEXT,
    examenes TEXT,
    evaluaciones TEXT,
    fecha DATE NOT NULL DEFAULT now(),
    id_examen_fisico INT,
    id_signos_vitales INT,
    id_hallazgos INT,
    CONSTRAINT tbl_evaluacion_retiro_pk PRIMARY KEY (id_evaluacion_retiro)
);


CREATE EXTENSION IF NOT EXISTS postgres_fdw;
CREATE SERVER svr_isp
	FOREIGN DATA WRAPPER postgres_fdw
	OPTIONS (dbname 'db_isp', host '192.168.217.16', port '5432');

CREATE USER MAPPING FOR postgres
    SERVER svr_isp
    OPTIONS (user 'postgres', password 'Gi%9875.-*5+$)(');
CREATE FOREIGN TABLE medicina.f_vta_empleado (
    id_empleado integer OPTIONS (column_name 'id_empleado') NULL,
    sucursal TEXT OPTIONS (column_name 'txt_sucursal'),
    cedula TEXT OPTIONS (column_name 'dni'),
    primer_apellido TEXT OPTIONS (column_name 'apellido'),
    primer_nombre TEXT OPTIONS (column_name 'nombre'),
    sexo TEXT OPTIONS (column_name 'txt_sexo'),
    edad INTEGER OPTIONS (column_name 'edad'),
    tipo_sangre TEXT OPTIONS (column_name 'tipo_sangre'),
    etnia TEXT OPTIONS (column_name 'etnia'),
    cargo TEXT OPTIONS (column_name 'cargo'),
    fecha_ingreso DATE OPTIONS (column_name 'fecha_ingreso'),
    departamento TEXT OPTIONS (column_name 'departamento'),
    discapacidad TEXT OPTIONS (column_name 'discapacidad'),
    id_rol integer OPTIONS (column_name 'id_rol') null,
    rol TEXT OPTIONS (column_name 'rol'),
    estado BOOLEAN OPTIONS (column_name 'estado')
    )
SERVER svr_isp OPTIONS (schema_name 'public', table_name 'vta_empleado');


CREATE TABLE medicina.tbl_antecedentes (
    id_antecedente int4 not null GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_historia_clinica INT NOT NULL, 
    antecedentes_clinicos_quirurgicos TEXT,
    antecedentes_gineco_obstetricos TEXT,
    menarquia_ciclos TEXT,
    fecha_ultima_menstruacion DATE,
    gestas INT,
    partos INT,
    cesareas INT,
    abortos INT,
    hijos_vivos INT,
    hijos_muertos INT,
    vida_sexual_activa BOOLEAN,
    metodo_planificacion_tipo TEXT,
    papanicolaou_tiempo_anios INT,
    papanicolaou_resultado TEXT,
    colposcopia_tiempo_anios INT,
    colposcopia_resultado TEXT,
    ant_reproductivos_masculinos BOOLEAN,
    metodo_planificacion_masculino TEXT,
    hijos_masculino_vivos INT,
    hijos_masculino_muertos INT,
    antigeno_prostatico_tiempo_anios INT,
    antigeno_prostatico_resultado TEXT,
    eco_prostatico_tiempo_anios INT,
    eco_prostatico_resultado TEXT,
    tabaco_tiempo_meses INT,
    tabaco_cantidad TEXT,
    tabaco_ex_consumidor BOOLEAN,
    tabaco_abstinencia_meses INT,
    alcohol_tiempo_meses INT,
    alcohol_cantidad TEXT,
    alcohol_ex_consumidor BOOLEAN,
    alcohol_abstinencia_meses INT,
    otras_drogas TEXT,
    otras_drogas_cantidad TEXT,
    actividad_fisica_dias_semana INT,
    estilo_vida TEXT,
    estilo_vida_tiempo TEXT,
    medicacion_habitual TEXT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_historia_clinica FOREIGN KEY (id_historia_clinica)
        REFERENCES medicina.tbl_historia_clinica(id_historia_clinica)
        ON DELETE CASCADE
);
CREATE TABLE medicina.tbl_antecedentes_trabajo (
    id_antecedente_trabajo int4 not null GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    empresa TEXT,
    puesto_trabajo TEXT,
    actividades TEXT,
    tiempo_trabajo_meses INTEGER,
    riesgo_fisico BOOLEAN,
    riesgo_mecanico BOOLEAN,
    riesgo_quimico BOOLEAN,
    riesgo_biologico BOOLEAN,
    riesgo_ergonomico BOOLEAN,
    riesgo_psicosocial BOOLEAN,
    observaciones_empleo TEXT,
    accidente_descripcion TEXT,
    accidente_calificado BOOLEAN,
    accidente_especificar TEXT,
    accidente_fecha DATE,
    accidente_observaciones TEXT,
    enfermedad_calificada BOOLEAN,
    enfermedad_especificar TEXT,
    enfermedad_fecha DATE,
    enfermedad_observaciones TEXT
);
CREATE TABLE medicina.tbl_antecedentes_familiares (
    id_antecedente_familiar SERIAL PRIMARY KEY,
    tipo_enfermedad INT NOT NULL, 
    descripcion TEXT NOT NULL     
);
CREATE TABLE medicina.cat_tipos_enfermedad_familiar (
    id_tipo INT PRIMARY KEY,
    nombre TEXT NOT NULL
);

INSERT INTO medicina.cat_tipos_enfermedad_familiar (id_tipo, nombre) VALUES
(1, 'Enfermedad Cardio-Vascular'),
(2, 'Enfermedad Metabólica'),
(3, 'Enfermedad Neurológica'),
(4, 'Enfermedad Oncológica'),
(5, 'Enfermedad Infecciosa'),
(6, 'Enfermedad Hereditaria / Congénita'),
(7, 'Discapacidades'),
(8, 'Otros');

CREATE TABLE medicina.tbl_factores_riesgo_trabajo (
    id_factores_riesgo_trabajo SERIAL PRIMARY KEY,
    puesto_trabajo TEXT,
    actividades TEXT,
    -- Físico
    riesgo_temp_alta BOOLEAN,
    riesgo_temp_baja BOOLEAN,
    riesgo_radiacion_ionizante BOOLEAN,
    riesgo_radiacion_no_ionizante BOOLEAN,
    riesgo_ruido BOOLEAN,
    riesgo_vibracion BOOLEAN,
    riesgo_iluminacion BOOLEAN,
    riesgo_ventilacion BOOLEAN,
    riesgo_fluido_electrico BOOLEAN,
    riesgo_fisico_otros TEXT,
    -- Mecánico
    riesgo_atrapamiento_maquinas BOOLEAN,
    riesgo_atrapamiento_superficies BOOLEAN,
    riesgo_atrapamiento_objetos BOOLEAN,
    riesgo_caida_objetos BOOLEAN,
    riesgo_caida_mismo_nivel BOOLEAN,
    riesgo_caida_diferente_nivel BOOLEAN,
    riesgo_contacto_superficies_trabajo BOOLEAN,
    riesgo_contacto_partes_fluido BOOLEAN,
    riesgo_proyeccion_particulas BOOLEAN,
    riesgo_proyeccion_fluido BOOLEAN,
    riesgo_pinchazos BOOLEAN,
    riesgo_cortes BOOLEAN,
    riesgo_atropellamiento_vehiculos BOOLEAN,
    riesgo_choque_vehicular BOOLEAN,
    riesgo_mecanico_otros TEXT,
    -- Químico
    riesgo_solidos BOOLEAN,
    riesgo_polvos BOOLEAN,
    riesgo_humos BOOLEAN,
    riesgo_liquidos BOOLEAN,
    riesgo_vapores BOOLEAN,
    riesgo_aerosoles BOOLEAN,
    riesgo_neblinas BOOLEAN,
    riesgo_gases BOOLEAN,
    riesgo_quimico_otros TEXT,
    -- Biológico
    riesgo_virus BOOLEAN,
    riesgo_hongos BOOLEAN,
    riesgo_bacterias BOOLEAN,
    riesgo_parasitos BOOLEAN,
    riesgo_exposicion_animales BOOLEAN,
    riesgo_exposicion_vector BOOLEAN,
    riesgo_biologico_otros TEXT,
    -- Ergonómico
    riesgo_manejo_cargas BOOLEAN,
    riesgo_movimientos_repetitivos BOOLEAN,
    riesgo_posturas_forzadas BOOLEAN,
    riesgo_trabajo_pvd BOOLEAN,
    riesgo_ergonomico_otros TEXT,
    -- Psicosocial
    riesgo_monotonia BOOLEAN,
    riesgo_cantidad_tarea BOOLEAN,
    riesgo_responsabilidad BOOLEAN,
    riesgo_alta_exigencia BOOLEAN,
    riesgo_supervision_autoridad BOOLEAN,
    riesgo_definicion_rol BOOLEAN,
    riesgo_conflicto_rol BOOLEAN,
    riesgo_falta_autonomia BOOLEAN,
    riesgo_inversion_trabajo BOOLEAN,
    riesgo_turnos BOOLEAN,
    riesgo_relaciones_interpersonales BOOLEAN,
    riesgo_inestabilidad_laboral BOOLEAN,
    riesgo_psicosocial_otros TEXT,
    -- Medidas preventivas
    medidas_preventivas TEXT
);

--AGREGAR CAMPOS A tbl_signo vital
ALTER TABLE medicina.tbl_signo_vital 
ADD COLUMN temperatura NUMERIC(5,2),
ADD COLUMN frecuencia_respiratoria INT,
ADD COLUMN peso NUMERIC(5,2),
ADD COLUMN talla NUMERIC(5,2),
ADD COLUMN masa_corporal NUMERIC(5,2),
ADD COLUMN perimetro_abdominal NUMERIC(5,2);

CREATE TABLE medicina.tbl_actividades_extra_laborales (
    id_actividad serial PRIMARY KEY,
    id_empleado INT NOT NULL,
    descripcion TEXT,
    fecha_registro DATE DEFAULT CURRENT_DATE
);
CREATE TABLE medicina.tbl_enfermedad_actual (
    id_enfermedad serial PRIMARY KEY,
    id_empleado INT NOT NULL,
    descripcion TEXT,
    fecha_registro DATE DEFAULT CURRENT_DATE
);
CREATE TABLE medicina.tbl_revision_organos_sistemas (
    id_revision serial PRIMARY KEY,
    id_empleado INT NOT NULL,
    piel_anexos BOOLEAN DEFAULT FALSE,
    organos_sentidos BOOLEAN DEFAULT FALSE,
    respiratorio BOOLEAN DEFAULT FALSE,
    cardio_vascular BOOLEAN DEFAULT FALSE,
    digestivo BOOLEAN DEFAULT FALSE,
    genito_urinario BOOLEAN DEFAULT FALSE,
    musculo_esqueletico BOOLEAN DEFAULT FALSE,
    endocrino BOOLEAN DEFAULT FALSE,
    hemo_linfatico BOOLEAN DEFAULT FALSE,
    nervioso BOOLEAN DEFAULT FALSE,
    descripcion TEXT,
    fecha_registro DATE DEFAULT CURRENT_DATE
);

CREATE TABLE medicina.tbl_examenes (
    id_examen SERIAL PRIMARY KEY,
    id_empleado INT NOT NULL,
    nombre_examen VARCHAR(100) NOT NULL,
    fecha_examen DATE NOT NULL,
    resultado TEXT,
    observaciones TEXT
);

CREATE TABLE medicina.tbl_diagnostico (
    id_diagnostico SERIAL PRIMARY KEY,
    id_empleado INT NOT NULL,
    descripcion TEXT NOT NULL,
    cie VARCHAR(10),
    es_presuntivo BOOLEAN DEFAULT FALSE,
    es_definitivo BOOLEAN DEFAULT FALSE
);

CREATE TABLE medicina.tbl_aptitud_medica (
    id_aptitud SERIAL PRIMARY KEY,
    id_empleado INT NOT NULL,
    apto BOOLEAN DEFAULT FALSE,
    apto_en_observacion BOOLEAN DEFAULT FALSE,
    apto_con_limitaciones BOOLEAN DEFAULT FALSE,
    no_apto BOOLEAN DEFAULT FALSE,
    observacion TEXT,
    limitacion TEXT
);

CREATE TABLE medicina.tbl_recomendaciones (
    id_recomendacion SERIAL PRIMARY KEY,
    id_empleado INT NOT NULL,
    descripcion TEXT
);

CREATE TABLE medicina.tbl_recetas_enviadas (
    id_receta SERIAL PRIMARY KEY,
    id_empleado INT NOT NULL,
    numero_receta VARCHAR(50) NOT NULL,
    fecha DATE NOT NULL,
    doctor_a VARCHAR(100) NOT NULL,
    diagnostico TEXT,
    receta TEXT
);


