INSERT INTO app_users (user_id) VALUES (2);
INSERT INTO app_users (user_id) VALUES (3);
INSERT INTO app_users (user_id) VALUES (4);
INSERT INTO app_users (user_id) VALUES (5);

INSERT INTO user_profiles (user_id) VALUES (2);
INSERT INTO user_profiles (user_id) VALUES (3);
INSERT INTO user_profiles (user_id) VALUES (4);
INSERT INTO user_profiles (user_id) VALUES (5);

INSERT INTO user_images (image_id, user_id, image) VALUES (1, 3, '0.png');
INSERT INTO user_interests (interest_id, user_id, interest) VALUES (1, 3, 'programming');

INSERT INTO genders (gender_id, name) VALUES (1, 'Male');
INSERT INTO genders (gender_id, name) VALUES (2, 'Female');
INSERT INTO genders (gender_id, name) VALUES (3, 'Non-binary');

INSERT INTO orientations (orientation_id, name) VALUES (1, 'Heterosexual');
INSERT INTO orientations (orientation_id, name) VALUES (2, 'Homosexual');

INSERT INTO personality_scales (personality_scale_id, name) VALUES (1, 'Very Low');
INSERT INTO personality_scales (personality_scale_id, name) VALUES (3, 'Neutral');
INSERT INTO personality_scales (personality_scale_id, name) VALUES (5, 'Very High');

INSERT INTO relationship_statuses (relationship_status_id, name) VALUES (1, 'Single');

INSERT INTO life_stages (life_stage_id, name) VALUES (1, 'Infant');
INSERT INTO child_genders (child_gender_id, name) VALUES (1, 'M');
INSERT INTO household_statuses (household_status_id, name) VALUES (1, 'Full-time');

INSERT INTO education_degrees (education_degree_id, name) VALUES (1, 'Bachelor''s');
INSERT INTO fluency_levels (fluency_level_id, name) VALUES (1, 'Native');
INSERT INTO vice_types (vice_type_id, name) VALUES (1, 'Smoking Cigarettes');
INSERT INTO vice_frequencies (vice_frequency_id, name) VALUES (1, 'Often');
INSERT INTO pet_types (pet_type_id, name) VALUES (1, 'Dogs');

INSERT INTO travel_frequencies (travel_frequency_id, name) VALUES (1, 'Rarely');
INSERT INTO travel_durations (travel_duration_id, name) VALUES (1, 'Short');
INSERT INTO travel_distances (travel_distance_id, name) VALUES (1, 'Near');
INSERT INTO travel_group_sizes (travel_group_size_id, name) VALUES (1, 'Solo');

INSERT INTO religions (religion_id, religion_name, branch_name)
VALUES (1, 'Christianity', 'Catholicism');

INSERT INTO location_preferences (user_id, use_local, distance_in_miles)
VALUES (2, TRUE, 20.0);
INSERT INTO social_personalities (
    user_id, openness_id, conscientiousness_id, extraversion_id, agreeableness_id, neuroticism_id
) VALUES (2, 3, 5, 1, 3, 1);
INSERT INTO gender_preferences (user_id, gender_id, is_trans, orientation_id)
VALUES (2, 1, FALSE, 1);
INSERT INTO relationship_preferences (user_id, status_id) VALUES (2, 1);
INSERT INTO children_preferences (user_id, more_children) VALUES (2, TRUE);
INSERT INTO children (child_id, user_id, life_stage_id, gender_id, household_status_id)
VALUES (1, 2, 1, 1, 1);
INSERT INTO age_preferences (
    user_id, birth_day, birth_month, birth_year, min_age, max_age
) VALUES (2, '01', 'January', '1990', 18, 99);
INSERT INTO religion_preferences (user_id, religion_id, importance, same_religion)
VALUES (2, 1, 5, TRUE);
INSERT INTO education_preferences (user_id, highest_degree_id, concentration, importance)
VALUES (2, 1, 'Computer Science', 3);
INSERT INTO language_preferences (user_id, importance) VALUES (2, 4);
INSERT INTO languages (language_id, user_id, language_name, fluency_level_id)
VALUES (1, 2, 'English', 1);
INSERT INTO vice_preferences (user_id, importance) VALUES (2, 2);
INSERT INTO vices (vice_id, user_id, vice_type_id, frequency_id)
VALUES (1, 2, 1, 1);
INSERT INTO pets_preferences (user_id, importance, is_allowed) VALUES (2, 5, TRUE);
INSERT INTO pets (pet_id, user_id, pet_type_id, quantity) VALUES (1, 2, 1, 1);
INSERT INTO travel_preferences (user_id, frequency_id, duration_id, distance_id, group_size_id, importance)
VALUES (2, 1, 1, 1, 1, 3);
INSERT INTO diet_preferences (user_id, importance) VALUES (2, 1);
INSERT INTO user_dietary_restrictions (user_id, restriction) VALUES (2, 'VEGAN');
