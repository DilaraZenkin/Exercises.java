-- Meetups Report

SELECT m.first_name || ' ' || m.last_name AS member,
 g.group_name  AS groups,
 e.event_name, DATE(e.start_date)
 
FROM event e
 JOIN member m USING (member_id)
  JOIN groups g USING(group_id)
 ;
 
 
        
        
        
        
      
        
        
        


