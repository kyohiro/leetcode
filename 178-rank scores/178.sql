select s.Score
    (select count(*)+1 from (select distinct(Score) from Scores) as UniqueScores where Score < s.Score) as Rank
from Scores s
order by Score DESC
