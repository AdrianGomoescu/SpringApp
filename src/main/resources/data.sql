insert into users (username, password, enabled)
values ('admin1',
        'password',
        true);

insert into authorities(username, authority)
values('admin1',
       'ROLE_ADMIN');