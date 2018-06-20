queryMaxPathByPid
===
select id,menu_path,depth from tbl_themis_menu where menu_path = (
	select max(menu_path) from tbl_themis_menu where pid=#pid#
)
