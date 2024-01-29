
package gitbucket.core.admin.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object userlist extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[List[gitbucket.core.model.Account],Map[String, List[String]],Boolean,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(users: List[gitbucket.core.model.Account], members: Map[String, List[String]], includeRemoved: Boolean, includeGroups: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*3.2*/gitbucket/*3.11*/.core.html.main("Manage Users")/*3.42*/{_display_(Seq[Any](format.raw/*3.43*/("""
  """),_display_(/*4.4*/gitbucket/*4.13*/.core.admin.html.menu("users")/*4.43*/{_display_(Seq[Any](format.raw/*4.44*/("""
    """),format.raw/*5.5*/("""<div class="pull-right" style="margin-bottom: 4px;">
      <a href=""""),_display_(/*6.17*/context/*6.24*/.path),format.raw/*6.29*/("""/admin/users/_newuser" class="btn btn-default">New user</a>
      <a href=""""),_display_(/*7.17*/context/*7.24*/.path),format.raw/*7.29*/("""/admin/users/_newgroup" class="btn btn-default">New group</a>
    </div>
    <label for="includeRemoved">
      <input type="checkbox" id="includeRemoved" name="includeRemoved" """),_display_(if(includeRemoved)/*10.91*/{_display_(Seq[Any](format.raw/*10.92*/("""checked""")))} else {null} ),format.raw/*10.100*/("""/>
      Include removed users
    </label>
    <label for="includeGroups">
      <input type="checkbox" id="includeGroups" name="includeGroups" """),_display_(if(includeGroups)/*14.88*/{_display_(Seq[Any](format.raw/*14.89*/("""checked""")))} else {null} ),format.raw/*14.97*/("""/>
      Include group accounts
    </label>
    <table class="table table-bordered table-hover">
      """),_display_(/*18.8*/users/*18.13*/.map/*18.17*/ { account =>_display_(Seq[Any](format.raw/*18.30*/("""
        """),format.raw/*19.9*/("""<tr>
          <td """),_display_(if(account.isRemoved)/*20.37*/{_display_(Seq[Any](format.raw/*20.38*/("""style="background-color: #dddddd;"""")))} else {null} ),format.raw/*20.73*/(""">
            <div class="pull-right">
              """),_display_(if(account.isGroupAccount)/*22.42*/{_display_(Seq[Any](format.raw/*22.43*/("""
                """),format.raw/*23.17*/("""<a href=""""),_display_(/*23.27*/context/*23.34*/.path),format.raw/*23.39*/("""/admin/users/"""),_display_(/*23.53*/account/*23.60*/.userName),format.raw/*23.69*/("""/_editgroup">Edit</a>
              """)))}else/*24.22*/{_display_(Seq[Any](format.raw/*24.23*/("""
                """),format.raw/*25.17*/("""<a href=""""),_display_(/*25.27*/context/*25.34*/.path),format.raw/*25.39*/("""/admin/users/"""),_display_(/*25.53*/account/*25.60*/.userName),format.raw/*25.69*/("""/_edituser">Edit</a>
              """)))}),format.raw/*26.16*/("""
            """),format.raw/*27.13*/("""</div>
            <div class="strong">
              """),_display_(/*29.16*/helpers/*29.23*/.avatarLink(account.userName, 20)),format.raw/*29.56*/("""
              """),_display_(if(account.isRemoved)/*30.37*/{_display_(Seq[Any](format.raw/*30.38*/("""
                """),_display_(/*31.18*/account/*31.25*/.userName),format.raw/*31.34*/("""
              """)))}else/*32.22*/{_display_(Seq[Any](format.raw/*32.23*/("""
                """),format.raw/*33.17*/("""<a href=""""),_display_(/*33.27*/helpers/*33.34*/.url(account.userName)),format.raw/*33.56*/("""">"""),_display_(/*33.59*/account/*33.66*/.userName),format.raw/*33.75*/("""</a>
              """)))}),format.raw/*34.16*/("""
              """),_display_(if(account.isGroupAccount)/*35.42*/{_display_(Seq[Any](format.raw/*35.43*/("""
                """),format.raw/*36.17*/("""(Group)
              """)))}else/*37.22*/{_display_(Seq[Any](format.raw/*37.23*/("""
                """),_display_(if(account.isAdmin)/*38.37*/{_display_(Seq[Any](format.raw/*38.38*/("""
                  """),format.raw/*39.19*/("""(Administrator)
                """)))}else/*40.24*/{_display_(Seq[Any](format.raw/*40.25*/("""
                  """),format.raw/*41.19*/("""(Normal)
                """)))}),format.raw/*42.18*/("""
              """)))}),format.raw/*43.16*/("""
              """),_display_(if(account.isGroupAccount)/*44.42*/{_display_(Seq[Any](format.raw/*44.43*/("""
                """),_display_(/*45.18*/members(account.userName)/*45.43*/.map/*45.47*/ { userName =>_display_(Seq[Any](format.raw/*45.61*/("""
                  """),_display_(/*46.20*/helpers/*46.27*/.avatarLink(userName, 20, tooltip = true)),format.raw/*46.68*/("""
                """)))}),format.raw/*47.18*/("""
              """)))} else {null} ),format.raw/*48.16*/("""
            """),format.raw/*49.13*/("""</div>
            <div>
              <hr>
              """),_display_(if(!account.isGroupAccount)/*52.43*/{_display_(Seq[Any](format.raw/*52.44*/("""
                """),format.raw/*53.17*/("""<i class="octicon octicon-mail"></i> """),_display_(/*53.55*/account/*53.62*/.mailAddress),format.raw/*53.74*/("""
              """)))} else {null} ),format.raw/*54.16*/("""
              """),_display_(/*55.16*/account/*55.23*/.url.map/*55.31*/ { url =>_display_(Seq[Any](format.raw/*55.40*/("""
                """),format.raw/*56.17*/("""<i class="octicon octicon-home"></i> """),_display_(/*56.55*/url),format.raw/*56.58*/("""
              """)))}),format.raw/*57.16*/("""
            """),format.raw/*58.13*/("""</div>
            <div>
              <span class="muted">Registered:</span> """),_display_(/*60.55*/helpers/*60.62*/.datetime(account.registeredDate)),format.raw/*60.95*/("""
              """),format.raw/*61.15*/("""<span class="muted">Updated:</span> """),_display_(/*61.52*/helpers/*61.59*/.datetime(account.updatedDate)),format.raw/*61.89*/("""
              """),_display_(if(!account.isGroupAccount)/*62.43*/{_display_(Seq[Any](format.raw/*62.44*/("""
                """),format.raw/*63.17*/("""<span class="muted">Last Login:</span> """),_display_(/*63.57*/account/*63.64*/.lastLoginDate.map(helpers.datetime)),format.raw/*63.100*/("""
              """)))} else {null} ),format.raw/*64.16*/("""
            """),format.raw/*65.13*/("""</div>
          </td>
        </tr>
      """)))}),format.raw/*68.8*/("""
    """),format.raw/*69.5*/("""</table>
  """)))}),format.raw/*70.4*/("""
""")))}),format.raw/*71.2*/("""
"""),format.raw/*72.1*/("""<script>
$(function()"""),format.raw/*73.13*/("""{"""),format.raw/*73.14*/("""
  """),format.raw/*74.3*/("""$('#includeRemoved,#includeGroups').click(function()"""),format.raw/*74.55*/("""{"""),format.raw/*74.56*/("""
    """),format.raw/*75.5*/("""location.href = '"""),_display_(/*75.23*/context/*75.30*/.path),format.raw/*75.35*/("""/admin/users?includeRemoved=' + $('#includeRemoved').prop('checked')
      + '&includeGroups=' + $('#includeGroups').prop('checked');
  """),format.raw/*77.3*/("""}"""),format.raw/*77.4*/(""");
"""),format.raw/*78.1*/("""}"""),format.raw/*78.2*/(""");
</script>
"""))
      }
    }
  }

  def render(users:List[gitbucket.core.model.Account],members:Map[String, List[String]],includeRemoved:Boolean,includeGroups:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(users,members,includeRemoved,includeGroups)(context)

  def f:((List[gitbucket.core.model.Account],Map[String, List[String]],Boolean,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (users,members,includeRemoved,includeGroups) => (context) => apply(users,members,includeRemoved,includeGroups)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/admin/userlist.scala.html
                  HASH: 309c37ed500be6168ca4a8e73edf61e16e0e93ca
                  MATRIX: 688->1|942->184|1005->220|1022->229|1061->260|1099->261|1128->265|1145->274|1183->304|1221->305|1252->310|1347->379|1362->386|1387->391|1489->467|1504->474|1529->479|1752->675|1791->676|1844->684|2034->847|2073->848|2125->856|2256->961|2270->966|2283->970|2334->983|2370->992|2438->1033|2477->1034|2556->1069|2663->1149|2702->1150|2747->1167|2784->1177|2800->1184|2826->1189|2867->1203|2883->1210|2913->1219|2973->1262|3012->1263|3057->1280|3094->1290|3110->1297|3136->1302|3177->1316|3193->1323|3223->1332|3290->1368|3331->1381|3413->1436|3429->1443|3483->1476|3547->1513|3586->1514|3631->1532|3647->1539|3677->1548|3716->1570|3755->1571|3800->1588|3837->1598|3853->1605|3896->1627|3926->1630|3942->1637|3972->1646|4023->1666|4092->1708|4131->1709|4176->1726|4222->1755|4261->1756|4325->1793|4364->1794|4411->1813|4467->1852|4506->1853|4553->1872|4610->1898|4657->1914|4726->1956|4765->1957|4810->1975|4844->2000|4857->2004|4909->2018|4956->2038|4972->2045|5034->2086|5083->2104|5143->2120|5184->2133|5297->2219|5336->2220|5381->2237|5446->2275|5462->2282|5495->2294|5555->2310|5598->2326|5614->2333|5631->2341|5678->2350|5723->2367|5788->2405|5812->2408|5859->2424|5900->2437|6006->2516|6022->2523|6076->2556|6119->2571|6183->2608|6199->2615|6250->2645|6320->2688|6359->2689|6404->2706|6471->2746|6487->2753|6545->2789|6605->2805|6646->2818|6720->2862|6752->2867|6794->2879|6826->2881|6854->2882|6903->2903|6932->2904|6962->2907|7042->2959|7071->2960|7103->2965|7148->2983|7164->2990|7190->2995|7353->3131|7381->3132|7411->3135|7439->3136
                  LINES: 14->1|17->2|20->3|20->3|20->3|20->3|21->4|21->4|21->4|21->4|22->5|23->6|23->6|23->6|24->7|24->7|24->7|27->10|27->10|27->10|31->14|31->14|31->14|35->18|35->18|35->18|35->18|36->19|37->20|37->20|37->20|39->22|39->22|40->23|40->23|40->23|40->23|40->23|40->23|40->23|41->24|41->24|42->25|42->25|42->25|42->25|42->25|42->25|42->25|43->26|44->27|46->29|46->29|46->29|47->30|47->30|48->31|48->31|48->31|49->32|49->32|50->33|50->33|50->33|50->33|50->33|50->33|50->33|51->34|52->35|52->35|53->36|54->37|54->37|55->38|55->38|56->39|57->40|57->40|58->41|59->42|60->43|61->44|61->44|62->45|62->45|62->45|62->45|63->46|63->46|63->46|64->47|65->48|66->49|69->52|69->52|70->53|70->53|70->53|70->53|71->54|72->55|72->55|72->55|72->55|73->56|73->56|73->56|74->57|75->58|77->60|77->60|77->60|78->61|78->61|78->61|78->61|79->62|79->62|80->63|80->63|80->63|80->63|81->64|82->65|85->68|86->69|87->70|88->71|89->72|90->73|90->73|91->74|91->74|91->74|92->75|92->75|92->75|92->75|94->77|94->77|95->78|95->78
                  -- GENERATED --
              */
          