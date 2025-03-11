
CREATE TABLE IF NOT EXISTS chats
(
    "id" bigint primary key not null,
    "content" varchar,
    "time" TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp
);

COMMENT ON table chats IS 'The table chats';
COMMENT ON COLUMN chats.id IS 'ID chats';
COMMENT ON COLUMN chats.content IS 'This content';