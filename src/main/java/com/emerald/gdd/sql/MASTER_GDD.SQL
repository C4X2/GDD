-- START MESSAGE_REGISTRY TABLE DEFINITION --
CREATE TABLE MESSAGE_REGISTRY (
    message_key  text,
    description  text,
    message      mediumtext,
    created_date date,
    update_date  date,
    retired_date date
    );
-- END MESSAGE_REGISTRY TABLE DEFINITION --

-- START MESSAGE_REGISTRY ENTRIES --
INSERT INTO MESSAGE_REGISTRY(message_key, description, message, created_date)
VALUES ("homepage","The header shown on the top of the webpage", "Game Desgin Document", CURDATE()),
 ("gddComment", "Explaination of what a GDD is.", "A Game Design Document, or GDD, defines every aspect of your game. Additionaly it acts as an orienting document for each stakeholder in your organization. As a GDD explicitly states the goals game development needs to meet , from the small technical requirements to the large conceptual challenges. Finally, A GDD is a resource for keeping a game true to its roots. If the game changes so should the GDD.", CURDATE()),
 ("contact_us", "Contact Us, header on the top of the webpage", "Contact Us", CURDATE()),
 ("license", "License, header on the top of the webpage", "License", CURDATE()),
 ("build", "Build, header on the top of the webpage", "Build Your Own", CURDATE()),
 ("about", "About, header on the top of the webpage", "About", CURDATE()),
 ("error", "Simple error message", "Error", CURDATE()),
 ("feedback_encouragement", "Encourage the user to give feedback.", "We care about your feedback!", CURDATE()),
 ("placeholder_user_input", "Placeholder text for the Contact Us page", "We care about your feedback!", CURDATE()),
 ("about_emerald", "About Page header", "About Emerald Softworks, Inc.", CURDATE()),
 ("home", "Home", "Home", CURDATE()),
 ("build_keyword", "The word build", "Build", CURDATE()),
 ("about_text", "A short description of Emerald Softworks, and it's CEO", "Emerald Softworks was founded in 2018 with a mission dedicated to providing open-source resources to game developers across the world.
	    			This site GDD, is one of the first fully produced sites developed by Emerald Softworks, Inc. however there is more on the way!
	    			The CEO and founder of Emerald Softworks, Inc. is Nate Brown who is currently working on his first game, Korlal, a JRPG developed in Unity Game Engine.
	    			We are always open for suggestions about how to better configure our services to better help others. So if you have any comments, recommendations or if
	    			you just want to reach out please feel free to", CURDATE()),
  ("content_provided_by", "Provding information about the license", "All content provided by this site is licensed under the Mozilla Public License 2.0 which can be found", CURDATE()),
  ("convience", "", "It is also pasted below for convience.", CURDATE()),
  ("outline_text", "Provide user encourgement to write story outline", "Provide a outline of the story of the game:", CURDATE());
-- END MESSAGE_REGISTRY ENTRIES --

-- START LICENSE TABLE DEFINITION --
CREATE TABLE LICENSE (
    license_key  text,
    description  text,
    text      	mediumtext,
    link_to_def  text,
    created_date date,
    update_date  date,
    retired_date date
    );
-- END LICENSE TABLE DEFINITION --

-- START ENUM_LICENSE TABLE DEFINITION --
CREATE TABLE ENUM_LICENSE (
    license_key  text,
    description  text,
    text      	mediumtext,
    link_to_def  text,
    created_date date,
    update_date  date,
    retired_date date
    );
-- END ENUM_LICENSE TABLE DEFINITION --

-- START ENUM_GAME_PLATFORM TABLE DEFINITION --
CREATE TABLE ENUM_GAME_PLATFORM (
    name              varchar(20),
    abbreviated_name  varchar(10),
    developer         varchar(20),
    media             varchar(20),
    os                varchar(30),
    manufacturer      mediumtext,
    is_current_system bool,
    link_to_def       text,
    release_date      date,
    created_date      date,
    update_date       date,
    retired_date      date
    );
-- END ENUM_GAME_PLATFORM TABLE DEFINITION --

-- START ENUM_GAME_PLATFORM TABLE ENTRIES --
INSERT INTO GDD.ENUM_GAME_PLATFORM (name, abbreviated_name, developer, media, os, manufacturer, is_current_system, link_to_def, release_date, created_date)
VALUES
("iOS", "iOS", "Apple","", "iOS", "Apple Inc.", 1, "https://www.apple.com/", STR_TO_DATE("20070109", "%Y %m %d"), CURDATE()),
("Android", "Android", "Google","", "Android", "Multiple", 1, "https://www.android.com/", STR_TO_DATE("20071105", "%Y %m %d"), CURDATE()),
("Nintendo Switch", "Switch", "Nintendo","", "Horizon", "Foxconn;Hosiden", 1, "https://www.nintendo.com/switch/",STR_TO_DATE("20170303", "%Y %m %d"), CURDATE()),
("Playstation 4", "PS4", "Sony","Blu-ray;DVD", "Orbis OS", "Sony Corporation", 1, "https://www.playstation.com/en-us/explore/ps4/",STR_TO_DATE("20131115", "%Y %m %d"), CURDATE()),
("Xbox One", "Xbox One", "Microsoft","Blu-ray;DVD;CD", "Xbox OS", "Flex Ltd.", 1, "https://www.xbox.com/en-US/", STR_TO_DATE("20131122", "%Y %m %d"), CURDATE()),
("Windows Desktop", "Windows", "Microsoft","Blu-ray;DVD;CD", "Windows OS", "Microsoft Corporation", 1, "https://www.microsoft.com/en-us/", STR_TO_DATE("19851120", "%Y %m %d"), CURDATE()),
("Linux Desktop", "Linux", "Multiple","Blu-ray;DVD;CD", "Linux", "", 1, "https://www.linux.com/", STR_TO_DATE("19910101", "%Y %m %d"), CURDATE()),
("Web-based Browser", "Web", "Multiple","N/A", "Multiple", "", 1, "",null, CURDATE()),
("Stadia", "Stadia", "Google","N/A", "Linux", "Google", 1, "https://store.google.com/us/product/stadia", STR_TO_DATE("20191119", "%Y %m %d"), CURDATE());

-- END ENUM_GAME_PLATFORM TABLE ENTRIES -- 

-- START ENUM_ESRB TABLE DEFINITION --
CREATE TABLE ENUM_ESRB (
	rating           varchar(30),
	full_rating      varchar(45),
	description      varchar(200),
	created_date      date,
    update_date       date,
    retired_date      date
);
-- END   ENUM_ESRB TABLE DEFINITION --

-- START ENUM_ESRB TABLE ENTRIES
INSERT INTO ENUM_ESRB (rating, full_rating, description, created_date)
VALUES
    ("E","Everyone","Content is generally suitable for all ages. May contain minimal cartoon, fantasy or mild violence and/or infrequent use of mild language.", CURDATE()),
    ("E10","Everyone 10+","Content is generally suitable for ages 10 and up. May contain more cartoon, fantasy or mild violence, mild language and/or minimal suggestive themes.", CURDATE()),
    ("T","Teen","Content is generally suitable for ages 13 and up. May contain violence, suggestive themes, crude humor, minimal blood, simulated gambling and/or infrequent use of strong language.", CURDATE()),
    ("M","Mature 17+","Content is generally suitable for ages 17 and up. May contain intense violence, blood and gore, sexual content and/or strong language.", CURDATE()),
    ("AO","Adults Only 18+","Content suitable only for adults ages 18 and up. May include prolonged scenes of intense violence, graphic sexual content and/or gambling with real currency.", CURDATE()),
    ("RP","Rating Pending","Not yet assigned a final ESRB rating. Appears only in advertising, marketing and promotional materials related to a physical (e.g., boxed) video game that is expected to carry an ESRB rating, and should be replaced by a game's rating once it has been assigned.", CURDATE()),
    ("EC","Early Childhood","Games with this rating contain content which is aimed towards a preschool audience. They do not contain content that parents would find objectionable to this audience", CURDATE());
--END ENUM_ESRB TABLE ENTRIES

-- START CONTACT_RECORD TABLE DEFINITION --
CREATE TABLE CONTACT_RECORD (
    reason            varchar(20),
    comment			  varchar(10),
    created_date      date,
    update_date       date,
    retired_date      date
    );
-- END ENUM_GAME_PLATFORM TABLE DEFINITION --
