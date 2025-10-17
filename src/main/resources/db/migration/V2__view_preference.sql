
CREATE OR REPLACE VIEW public.preference
 AS
 SELECT loans.user_id,
    books.category_id
   FROM loans
     JOIN books ON loans.book_id = books.id;

ALTER TABLE public.preference
    OWNER TO postgres;
