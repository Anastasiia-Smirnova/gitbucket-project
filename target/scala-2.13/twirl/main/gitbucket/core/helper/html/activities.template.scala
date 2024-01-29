
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object activities extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[List[gitbucket.core.model.Activity],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(activities: List[gitbucket.core.model.Activity])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.view.helpers

def /*36.2*/simpleActivity/*36.16*/(activity: gitbucket.core.model.Activity):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*36.61*/("""
  """),format.raw/*37.3*/("""<div>
    <span class="muted small">"""),_display_(/*38.32*/gitbucket/*38.41*/.core.helper.html.datetimeago(activity.activityDate)),format.raw/*38.93*/("""</span>
    <div>
      """),_display_(/*40.8*/helpers/*40.15*/.avatarLink(activity.activityUserName, 16)),format.raw/*40.57*/("""
      """),_display_(/*41.8*/helpers/*41.15*/.activityMessage(activity.message)),format.raw/*41.49*/("""
    """),format.raw/*42.5*/("""</div>
  </div>
""")))};def /*46.2*/pushActivity/*46.14*/(activity: gitbucket.core.model.Activity):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*46.59*/("""
  """),format.raw/*47.3*/("""<div>
    <div class="muted small">"""),_display_(/*48.31*/gitbucket/*48.40*/.core.helper.html.datetimeago(activity.activityDate)),format.raw/*48.92*/("""</div>
    <div class="strong">
      """),_display_(/*50.8*/helpers/*50.15*/.avatarLink(activity.activityUserName, 16)),format.raw/*50.57*/("""
      """),_display_(/*51.8*/helpers/*51.15*/.activityMessage(activity.message)),format.raw/*51.49*/("""
    """),format.raw/*52.5*/("""</div>
    <div class="small activity-message">
      """),_display_(/*54.8*/activity/*54.16*/.additionalInfo.get.split("\n").reverse.take(4).zipWithIndex.map/*54.80*/ { case (commit, i) =>_display_(Seq[Any](format.raw/*54.102*/("""
        """),_display_(if(i == 3)/*55.20*/{_display_(Seq[Any](format.raw/*55.21*/("""
          """),format.raw/*56.11*/("""<div>...</div>
        """)))}else/*57.16*/{_display_(Seq[Any](format.raw/*57.17*/("""
          """),_display_(if(commit.nonEmpty)/*58.31*/{_display_(Seq[Any](format.raw/*58.32*/("""
            """),format.raw/*59.13*/("""<div>
              <a href=""""),_display_(/*60.25*/{context.path}),format.raw/*60.39*/("""/"""),_display_(/*60.41*/{activity.userName}),format.raw/*60.60*/("""/"""),_display_(/*60.62*/{activity.repositoryName}),format.raw/*60.87*/("""/commit/"""),_display_(/*60.96*/{commit. substring(0, 40)}),format.raw/*60.122*/("""" class="monospace">"""),_display_(/*60.143*/{commit.substring(0, 7)}),format.raw/*60.167*/("""</a>
              <span>"""),_display_(/*61.22*/{commit.substring(41)}),format.raw/*61.44*/("""</span>
           </div>
          """)))} else {null} ),format.raw/*63.12*/("""
        """)))}),format.raw/*64.10*/("""
      """)))}),format.raw/*65.8*/("""
    """),format.raw/*66.5*/("""</div>
  </div>
""")))};def /*70.2*/createWikiActivity/*70.20*/(activity: gitbucket.core.model.Activity):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*70.65*/("""
  """),format.raw/*71.3*/("""<div>
    <div class="muted small">"""),_display_(/*72.31*/gitbucket/*72.40*/.core.helper.html.datetimeago(activity.activityDate)),format.raw/*72.92*/("""</div>
    <div class="strong">
      """),_display_(/*74.8*/helpers/*74.15*/.avatarLink(activity.activityUserName, 16)),format.raw/*74.57*/("""
      """),_display_(/*75.8*/helpers/*75.15*/.activityMessage(activity.message)),format.raw/*75.49*/("""
    """),format.raw/*76.5*/("""</div>
    <div class="small activity-message">
      Created <a href=""""),_display_(/*78.25*/{context.path}),format.raw/*78.39*/("""/"""),_display_(/*78.41*/{activity.userName}),format.raw/*78.60*/("""/"""),_display_(/*78.62*/{activity.repositoryName}),format.raw/*78.87*/("""/wiki/"""),_display_(/*78.94*/{activity.additionalInfo}),format.raw/*78.119*/("""">"""),_display_(/*78.122*/{activity.additionalInfo}),format.raw/*78.147*/("""</a>.
    </div>
  </div>
""")))};def /*83.2*/editWikiActivity/*83.18*/(activity: gitbucket.core.model.Activity):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*83.63*/("""
  """),format.raw/*84.3*/("""<div>
    <div class="muted small">"""),_display_(/*85.31*/gitbucket/*85.40*/.core.helper.html.datetimeago(activity.activityDate)),format.raw/*85.92*/("""</div>
    <div class="strong">
      """),_display_(/*87.8*/helpers/*87.15*/.avatarLink(activity.activityUserName, 16)),format.raw/*87.57*/("""
      """),_display_(/*88.8*/helpers/*88.15*/.activityMessage(activity.message)),format.raw/*88.49*/("""
    """),format.raw/*89.5*/("""</div>
    """),_display_(/*90.6*/defining(activity.additionalInfo.get.split(":"))/*90.54*/{ additionalInfo =>_display_(Seq[Any](format.raw/*90.73*/("""
      """),_display_(if(additionalInfo.length == 2)/*91.38*/ {_display_(Seq[Any](format.raw/*91.40*/("""
        """),_display_(/*92.10*/defining((additionalInfo(0), additionalInfo(1)))/*92.58*/ { case (pageName, commitId) =>_display_(Seq[Any](format.raw/*92.89*/("""
          """),format.raw/*93.11*/("""<div class="small activity-message">
            Edited <a href=""""),_display_(/*94.30*/{context.path}),format.raw/*94.44*/("""/"""),_display_(/*94.46*/{activity.userName}),format.raw/*94.65*/("""/"""),_display_(/*94.67*/{activity.repositoryName}),format.raw/*94.92*/("""/wiki/"""),_display_(/*94.99*/pageName),format.raw/*94.107*/("""">"""),_display_(/*94.110*/pageName),format.raw/*94.118*/("""</a>.
            <a href=""""),_display_(/*95.23*/{context.path}),format.raw/*95.37*/("""/"""),_display_(/*95.39*/{activity.userName}),format.raw/*95.58*/("""/"""),_display_(/*95.60*/{activity.repositoryName}),format.raw/*95.85*/("""/wiki/"""),_display_(/*95.92*/{pageName}),format.raw/*95.102*/("""/_compare/"""),_display_(/*95.113*/{commitId.substring(0, 7)}),format.raw/*95.139*/("""^..."""),_display_(/*95.144*/{commitId.substring(0, 7)}),format.raw/*95.170*/("""">View the diff »</a>
          </div>
        """)))}),format.raw/*97.10*/("""
      """)))} else {null} ),format.raw/*98.8*/("""
      """),_display_(if(additionalInfo.length == 1)/*99.38*/ {_display_(Seq[Any](format.raw/*99.40*/("""
        """),_display_(/*100.10*/defining(additionalInfo(0))/*100.37*/ { pageName =>_display_(Seq[Any](format.raw/*100.51*/("""
          """),format.raw/*101.11*/("""<div class="small activity-message">
            Edited <a href=""""),_display_(/*102.30*/{context.path}),format.raw/*102.44*/("""/"""),_display_(/*102.46*/{activity.userName}),format.raw/*102.65*/("""/"""),_display_(/*102.67*/{activity.repositoryName}),format.raw/*102.92*/("""/wiki/"""),_display_(/*102.99*/{pageName}),format.raw/*102.109*/("""">"""),_display_(/*102.112*/pageName),format.raw/*102.120*/("""</a>.
          </div>
        """)))}),format.raw/*104.10*/("""
      """)))} else {null} ),format.raw/*105.8*/("""
    """)))}),format.raw/*106.6*/("""
  """),format.raw/*107.3*/("""</div>
""")))};
Seq[Any](format.raw/*3.1*/("""
"""),_display_(if(activities.isEmpty)/*4.24*/{_display_(Seq[Any](format.raw/*4.25*/("""
  """),format.raw/*5.3*/("""No activity
""")))}else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
  """),_display_(/*7.4*/activities/*7.14*/.map/*7.18*/ { activity =>_display_(Seq[Any](format.raw/*7.32*/("""
    """),format.raw/*8.5*/("""<div class="block">
      """),_display_(/*9.8*/(activity.activityType match {
        case "open_issue"          => simpleActivity(activity)
        case "comment_issue"       => simpleActivity(activity)
        case "comment_commit"      => simpleActivity(activity)
        case "close_issue"         => simpleActivity(activity)
        case "reopen_issue"        => simpleActivity(activity)
        case "open_pullreq"        => simpleActivity(activity)
        case "merge_pullreq"       => simpleActivity(activity)
        case "release"             => simpleActivity(activity)
        case "create_repository"   => simpleActivity(activity)
        case "delete_repository"   => simpleActivity(activity)
        case "rename_repository"   => simpleActivity(activity)
        case "transfer_repository" => simpleActivity(activity)
        case "create_branch"       => simpleActivity(activity)
        case "delete_branch"       => simpleActivity(activity)
        case "create_tag"          => simpleActivity(activity)
        case "delete_tag"          => simpleActivity(activity)
        case "fork"                => simpleActivity(activity)
        case "push"                => pushActivity(activity)
        case "create_wiki"         => createWikiActivity(activity)
        case "edit_wiki"           => editWikiActivity(activity)
        case "delete_wiki"         => simpleActivity(activity)
      })),format.raw/*31.9*/("""
    """),format.raw/*32.5*/("""</div>
  """)))}),format.raw/*33.4*/("""
""")))}),format.raw/*34.2*/("""

"""),format.raw/*44.2*/("""

"""),format.raw/*68.2*/("""

"""),format.raw/*81.2*/("""

"""),format.raw/*108.2*/("""
"""))
      }
    }
  }

  def render(activities:List[gitbucket.core.model.Activity],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(activities)(context)

  def f:((List[gitbucket.core.model.Activity]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (activities) => (context) => apply(activities)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/activities.scala.html
                  HASH: a478d1d57a45270a9c7eb1039719fbea00def0a0
                  MATRIX: 650->1|825->105|873->1638|896->1652|1018->1697|1048->1700|1112->1737|1130->1746|1203->1798|1254->1823|1270->1830|1333->1872|1367->1880|1383->1887|1438->1921|1470->1926|1510->1946|1531->1958|1653->2003|1683->2006|1746->2042|1764->2051|1837->2103|1902->2142|1918->2149|1981->2191|2015->2199|2031->2206|2086->2240|2118->2245|2199->2300|2216->2308|2289->2372|2350->2394|2397->2414|2436->2415|2475->2426|2522->2456|2561->2457|2619->2488|2658->2489|2699->2502|2756->2532|2791->2546|2820->2548|2860->2567|2889->2569|2935->2594|2971->2603|3019->2629|3068->2650|3114->2674|3167->2700|3210->2722|3291->2759|3332->2769|3370->2777|3402->2782|3442->2802|3469->2820|3591->2865|3621->2868|3684->2904|3702->2913|3775->2965|3840->3004|3856->3011|3919->3053|3953->3061|3969->3068|4024->3102|4056->3107|4155->3179|4190->3193|4219->3195|4259->3214|4288->3216|4334->3241|4368->3248|4415->3273|4446->3276|4493->3301|4543->3331|4568->3347|4690->3392|4720->3395|4783->3431|4801->3440|4874->3492|4939->3531|4955->3538|5018->3580|5052->3588|5068->3595|5123->3629|5155->3634|5193->3646|5250->3694|5307->3713|5372->3751|5412->3753|5449->3763|5506->3811|5575->3842|5614->3853|5707->3919|5742->3933|5771->3935|5811->3954|5840->3956|5886->3981|5920->3988|5950->3996|5981->3999|6011->4007|6066->4035|6101->4049|6130->4051|6170->4070|6199->4072|6245->4097|6279->4104|6311->4114|6350->4125|6398->4151|6431->4156|6479->4182|6558->4230|6609->4238|6674->4276|6714->4278|6752->4288|6789->4315|6842->4329|6882->4340|6976->4406|7012->4420|7042->4422|7083->4441|7113->4443|7160->4468|7195->4475|7228->4485|7260->4488|7291->4496|7355->4528|7407->4536|7444->4542|7475->4545|7521->140|7571->164|7609->165|7638->168|7672->187|7709->188|7738->192|7756->202|7768->206|7819->220|7850->225|7902->252|9288->1618|9320->1623|9360->1633|9392->1635|9421->1943|9450->2799|9479->3328|9509->4553
                  LINES: 14->1|17->2|19->36|19->36|21->36|22->37|23->38|23->38|23->38|25->40|25->40|25->40|26->41|26->41|26->41|27->42|29->46|29->46|31->46|32->47|33->48|33->48|33->48|35->50|35->50|35->50|36->51|36->51|36->51|37->52|39->54|39->54|39->54|39->54|40->55|40->55|41->56|42->57|42->57|43->58|43->58|44->59|45->60|45->60|45->60|45->60|45->60|45->60|45->60|45->60|45->60|45->60|46->61|46->61|48->63|49->64|50->65|51->66|53->70|53->70|55->70|56->71|57->72|57->72|57->72|59->74|59->74|59->74|60->75|60->75|60->75|61->76|63->78|63->78|63->78|63->78|63->78|63->78|63->78|63->78|63->78|63->78|66->83|66->83|68->83|69->84|70->85|70->85|70->85|72->87|72->87|72->87|73->88|73->88|73->88|74->89|75->90|75->90|75->90|76->91|76->91|77->92|77->92|77->92|78->93|79->94|79->94|79->94|79->94|79->94|79->94|79->94|79->94|79->94|79->94|80->95|80->95|80->95|80->95|80->95|80->95|80->95|80->95|80->95|80->95|80->95|80->95|82->97|83->98|84->99|84->99|85->100|85->100|85->100|86->101|87->102|87->102|87->102|87->102|87->102|87->102|87->102|87->102|87->102|87->102|89->104|90->105|91->106|92->107|94->3|95->4|95->4|96->5|97->6|97->6|98->7|98->7|98->7|98->7|99->8|100->9|122->31|123->32|124->33|125->34|127->44|129->68|131->81|133->108
                  -- GENERATED --
              */
          