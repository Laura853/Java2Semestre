create table t_tdspw_funcionario(
        cd_funcionario number(6,0) primary key,
        nm_funcionario varchar(100),
        vl_salario number(10,2),
        st_ativo number(1,0),
        ds_email varchar(80)
);

create sequence seq_tdspw_funcionario start with 1 increment by 1 nocache;