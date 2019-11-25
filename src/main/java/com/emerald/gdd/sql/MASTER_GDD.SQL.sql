-- START MESSAGE_REGISTRY TABLE DEFINITION --
CREATE TABLE MESSAGE_REGISTRY (
	message_key text,
    description text,
    message     mediumtext,
    created_date date,
    update_date date,
    retired_date date
    );
-- END MESSAGE_REGISTRY TABLE DEFINITION --