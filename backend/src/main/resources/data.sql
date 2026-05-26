-- 预置用户 (密码明文仅用于演示，生产环境需加密)
INSERT INTO users (username, password, name, phone, role, created_at) VALUES ('dengjb', '123456', '邓建斌', '138****1234', '学生', NOW());
INSERT INTO users (username, password, name, phone, role, created_at) VALUES ('liupeng', '123456', '刘鹏', '139****5678', '学生', NOW());
INSERT INTO users (username, password, name, phone, role, created_at) VALUES ('liuyk', '123456', '刘耀坤', '136****9012', '学生', NOW());

-- 预置商品
INSERT INTO items (title, description, price, orig_price, category, seller_id, seller_name, sold, created_date) VALUES ('高等数学（第七版）上下册', '九成新，只有少量笔记，考研必备教材', 25, 78, '教材', 2, '刘鹏', false, '2026-05-20');
INSERT INTO items (title, description, price, orig_price, category, seller_id, seller_name, sold, created_date) VALUES ('罗技K380蓝牙键盘', '用了半年，换了机械键盘所以出，功能完好，送电池', 89, 179, '电子', 3, '刘耀坤', false, '2026-05-19');
INSERT INTO items (title, description, price, orig_price, category, seller_id, seller_name, sold, created_date) VALUES ('宿舍床头收纳挂篮', '黑色铁艺，几乎全新，毕业清仓', 12, 35, '生活', 1, '邓建斌', false, '2026-05-22');
INSERT INTO items (title, description, price, orig_price, category, seller_id, seller_name, sold, created_date) VALUES ('iPad Air 4 64G 深空灰', '国行过保，屏幕完美，边框轻微使用痕迹，带原装充电器', 2100, 4399, '电子', 2, '刘鹏', false, '2026-05-18');
INSERT INTO items (title, description, price, orig_price, category, seller_id, seller_name, sold, created_date) VALUES ('尤尼克斯羽毛球拍 NR-700', '入门级，线是24磅BG65，适合新手练习', 150, 320, '运动', 3, '刘耀坤', false, '2026-05-21');
INSERT INTO items (title, description, price, orig_price, category, seller_id, seller_name, sold, created_date) VALUES ('数据结构（C语言版）严蔚敏', '计算机专业经典教材，保护得不错，笔记工整', 18, 45, '教材', 1, '邓建斌', false, '2026-05-17');
INSERT INTO items (title, description, price, orig_price, category, seller_id, seller_name, sold, created_date) VALUES ('小米台灯1S 白色', 'LED护眼台灯，支持米家APP控制，无拆无修', 65, 149, '生活', 2, '刘鹏', false, '2026-05-16');
INSERT INTO items (title, description, price, orig_price, category, seller_id, seller_name, sold, created_date) VALUES ('NIKE Air Force 1 纯白 42码', '穿了一个月不太合脚，9成新，鞋盒吊牌都在', 380, 799, '服饰', 3, '刘耀坤', false, '2026-05-15');
INSERT INTO items (title, description, price, orig_price, category, seller_id, seller_name, sold, created_date) VALUES ('考研英语真题（2021-2025）', '只做了一套，其余全新，赠答题卡和视频课', 22, 59, '教材', 1, '邓建斌', false, '2026-05-23');
INSERT INTO items (title, description, price, orig_price, category, seller_id, seller_name, sold, created_date) VALUES ('Switch Pro手柄 国行正品', '使用不超过20小时，无漂移，箱说全', 199, 459, '电子', 2, '刘鹏', false, '2026-05-14');
