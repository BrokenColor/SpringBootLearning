| 关键词|  样品|  JPQL代码段 |  
| :------ | :------ | :------ |  
|  And|  findByLastnameAndFirstname|  … where x.lastname = ?1 and x.firstname = ?2 |  
| Or| findByLastnameOrFirstname| … where x.lastname = ?1 or x.firstname = ?2 | 
| Is,Equals| findByFirstname，findByFirstnameIs，findByFirstnameEquals| … where x.firstname = ?1 | 
| Between| findByStartDateBetween| … where x.startDate between ?1 and ?2 | 
| LessThan| findByAgeLessThan| … where x.age < ?1 | 
| LessThanEqual| findByAgeLessThanEqual| … where x.age ⇐ ?1 | 
| GreaterThan| findByAgeGreaterThan| … where x.age > ?1 | 
| GreaterThanEqual| findByAgeGreaterThanEqual| … where x.age >= ?1 | 
| After| findByStartDateAfter| … where x.startDate > ?1 | 
| Before| findByStartDateBefore| … where x.startDate < ?1 |
| IsNull| findByAgeIsNull| … where x.age is null |
| IsNotNull,NotNull| findByAge(Is)NotNull| … where x.age not null |
| Like| findByFirstnameLike| … where x.firstname like ?1 |
| NotLike| findByFirstnameNotLike| … where x.firstname not like ?1 |
| StartingWith| findByFirstnameStartingWith| … where x.firstname like ?1（附加参数绑定%） |
| EndingWith| findByFirstnameEndingWith| … where x.firstname like ?1（与前置绑定的参数%） | 
| Containing| findByFirstnameContaining| … where x.firstname like ?1（包含参数绑定%） |
| OrderBy| findByAgeOrderByLastnameDesc| … where x.age = ?1 order by x.lastname desc | 
| Not| findByLastnameNot| … where x.lastname <> ?1 |
| In| findByAgeIn(Collection<Age> ages)| … where x.age in ?1 |
| NotIn| findByAgeNotIn(Collection<Age> age)| … where x.age not in ?1 | 
| TRUE| findByActiveTrue()| … where x.active = true |
| FALSE| findByActiveFalse()| … where x.active = false | 
| IgnoreCase| findByFirstnameIgnoreCase| … where UPPER(x.firstame) = UPPER(?1) |