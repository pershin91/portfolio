do
$product$
    begin
        if not exists(select 1 from product where code = 'book')
        then
            insert into public.product (name, code, price)
            values ('Book about...', 'book', 123);
        end if;
    end
$product$
