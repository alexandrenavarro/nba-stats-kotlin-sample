import khttp.get

fun main(args: Array<String>) {

    // Get your playerId via  https://stats.nba.com/stats/commonallplayers/?leagueId=00&season=2018-19
    // 201939 is Stephen Curry

    // Get Award of Stephen Curry
    var playerAwards = get("https://stats.nba.com/stats/playerawards/?playerId=201939").jsonObject.getJSONArray("resultSets").getJSONObject(0).getJSONArray("rowSet")
    for (i in 0..(playerAwards.length() - 1)) {
        val award = playerAwards.getJSONArray(i)
        val awardDateIfPresent = if (award[7] is String) " on ${award[7]}" else ""
        println("During the season ${award[6]}$awardDateIfPresent, ${award[1]} ${award[2]} won ${award[4]} ")
    }

}