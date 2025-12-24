-- Sample Users
-- BCrypt hash for "admin123"
INSERT INTO users (username, password) VALUES
('admin', '$2a$10$Dow1xZVb2L9Ww9nEJ4zU8u5wYl1WcU9Zz3J5K2E0kJm2F0Zr6q5iG'),
('user1', '$2a$10$Dow1xZVb2L9Ww9nEJ4zU8u5wYl1WcU9Zz3J5K2E0kJm2F0Zr6q5iG');


-- Sample Assets
INSERT INTO assets (id, asset_name, asset_type, serial_number, deleted) VALUES
(1, 'Dell Laptop', 'Electronics', 'DL-1001', false),
(2, 'HP Printer', 'Electronics', 'HP-2002', false),
(3, 'Office Chair', 'Furniture', 'CH-3003', false),
(4, 'Projector', 'Electronics', 'PJ-4004', true);
