CREATE TABLE IF NOT EXISTS notes
(
    "id" bigint primary key not null,
    "data" TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
    "topic" varchar,
    "text_notes" varchar
);

COMMENT ON table notes IS 'The table notes';
COMMENT ON COLUMN notes.id IS 'ID note';
COMMENT ON COLUMN notes.topic IS 'This field note';
COMMENT ON COLUMN notes.text_notes IS 'Text note';