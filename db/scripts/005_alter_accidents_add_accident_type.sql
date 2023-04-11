ALTER TABLE accidents ADD COLUMN id_accident_type int references accident_types(id);
