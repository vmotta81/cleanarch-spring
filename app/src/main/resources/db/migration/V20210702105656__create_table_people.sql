create TABLE people (
	id uuid NOT NULL UNIQUE,
	name varchar(255),
	CONSTRAINT person_pkey PRIMARY KEY (id)
);
