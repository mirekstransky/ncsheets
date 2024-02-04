INSERT INTO program (name, technologist, itemname) VALUES ('Program 1','STRANSKY','SOUCAST 1');
INSERT INTO program (name, technologist, itemname) VALUES ('Program 2','STRANSKY','SOUCAST 2');
INSERT INTO program (name, technologist, itemname) VALUES ('Program 3','STRANSKY','SOUCAST 3');
INSERT INTO program (name, technologist, itemname) VALUES ('Program 4','STRANSKY','SOUCAST 4');
INSERT INTO program (name, technologist, itemname) VALUES ('Program 5','STRANSKY','SOUCAST 5');
INSERT INTO program (name, technologist, itemname) VALUES ('Program 6','STRANSKY','SOUCAST 6');
--
INSERT INTO assemble(name,program_id,adapter_id,holder_id,tool_id,tool_position,tool_length,compensation_x,compensation_z)
VALUES ('S_1',1,1,1,1,1,1,10,10);

INSERT INTO assemble(name,program_id,adapter_id,holder_id,tool_id,tool_position,tool_length,compensation_x,compensation_z)
VALUES ('S_2',2,2,2,2,2,2,20,20);

INSERT INTO assemble(name,program_id,adapter_id,holder_id,tool_id,tool_position,tool_length,compensation_x,compensation_z)
VALUES ('S_3',3,3,3,3,3,3,30,30);

INSERT INTO assemble(name,program_id,adapter_id,holder_id,tool_id,tool_position,tool_length,compensation_x,compensation_z)
VALUES ('S_4',4,4,4,4,4,4,40,40);

INSERT INTO assemble(name,program_id,adapter_id,holder_id,tool_id,tool_position,tool_length,compensation_x,compensation_z)
VALUES ('S_5',5,5,5,5,5,5,50,50);