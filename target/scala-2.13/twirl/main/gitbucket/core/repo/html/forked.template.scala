
package gitbucket.core.repo.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object forked extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[Option[gitbucket.core.service.RepositoryService.RepositoryInfo],List[(String, String)],List[String],gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(originRepository: Option[gitbucket.core.service.RepositoryService.RepositoryInfo],
  members: List[(String, String)],
  groupNames: List[String],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.html.main(s"${repository.owner}/${repository.name}", Some(repository))/*6.87*/ {_display_(Seq[Any](format.raw/*6.89*/("""
  """),_display_(/*7.4*/gitbucket/*7.13*/.core.html.menu("fork", repository)/*7.48*/{_display_(Seq[Any](format.raw/*7.49*/("""
    """),format.raw/*8.5*/("""<h1 class="body-title">Forked repositories</h1>
    <div class="block">
      """),_display_(if(originRepository.isDefined)/*10.38*/{_display_(Seq[Any](format.raw/*10.39*/("""
        """),_display_(/*11.10*/helpers/*11.17*/.avatarLink(originRepository.get.owner, 20)),format.raw/*11.60*/("""
        """),format.raw/*12.9*/("""<span"""),_display_(if(repository.owner == originRepository.get.owner)/*12.65*/{_display_(Seq[Any](format.raw/*12.66*/(""" """),format.raw/*12.67*/("""class="highlight"""")))} else {null} ),format.raw/*12.85*/(""">
          <a href=""""),_display_(/*13.21*/helpers/*13.28*/.url(originRepository.get.owner)),format.raw/*13.60*/("""">"""),_display_(/*13.63*/originRepository/*13.79*/.get.owner),format.raw/*13.89*/("""</a> / <a href=""""),_display_(/*13.106*/context/*13.113*/.path),format.raw/*13.118*/("""/"""),_display_(/*13.120*/originRepository/*13.136*/.get.owner),format.raw/*13.146*/("""/"""),_display_(/*13.148*/originRepository/*13.164*/.get.name),format.raw/*13.173*/("""">"""),_display_(/*13.176*/originRepository/*13.192*/.get.name),format.raw/*13.201*/("""</a>
        </span>
      """)))}else/*15.14*/{_display_(Seq[Any](format.raw/*15.15*/("""
        """),_display_(/*16.10*/helpers/*16.17*/.avatar(repository.repository.originUserName.get, 20)),format.raw/*16.70*/("""
        """),format.raw/*17.9*/("""<span class="highlight">
          """),_display_(/*18.12*/repository/*18.22*/.repository.originUserName),format.raw/*18.48*/(""" """),format.raw/*18.49*/("""/ """),_display_(/*18.52*/repository/*18.62*/.repository.originRepositoryName),format.raw/*18.94*/("""
        """),format.raw/*19.9*/("""</span>
      """)))}),format.raw/*20.8*/("""
      """),format.raw/*21.7*/("""(origin)
    </div>
    """),_display_(/*23.6*/members/*23.13*/.map/*23.17*/ { case (owner, name) =>_display_(Seq[Any](format.raw/*23.41*/("""
      """),format.raw/*24.7*/("""<div class="block">
        """),_display_(/*25.10*/helpers/*25.17*/.avatarLink(owner, 20)),format.raw/*25.39*/("""
        """),format.raw/*26.9*/("""<span"""),_display_(if(repository.owner == owner)/*26.44*/{_display_(Seq[Any](format.raw/*26.45*/(""" """),format.raw/*26.46*/("""class="highlight"""")))} else {null} ),format.raw/*26.64*/(""">
          <a href=""""),_display_(/*27.21*/helpers/*27.28*/.url(owner)),format.raw/*27.39*/("""">"""),_display_(/*27.42*/owner),format.raw/*27.47*/("""</a> / <a href=""""),_display_(/*27.64*/context/*27.71*/.path),format.raw/*27.76*/("""/"""),_display_(/*27.78*/owner),format.raw/*27.83*/("""/"""),_display_(/*27.85*/name),format.raw/*27.89*/("""">"""),_display_(/*27.92*/name),format.raw/*27.96*/("""</a>
        </span>
      </div>
    """)))}),format.raw/*30.6*/("""
  """)))}),format.raw/*31.4*/("""
""")))}),format.raw/*32.2*/("""
"""))
      }
    }
  }

  def render(originRepository:Option[gitbucket.core.service.RepositoryService.RepositoryInfo],members:List[(String, String)],groupNames:List[String],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(originRepository,members,groupNames,repository)(context)

  def f:((Option[gitbucket.core.service.RepositoryService.RepositoryInfo],List[(String, String)],List[String],gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (originRepository,members,groupNames,repository) => (context) => apply(originRepository,members,groupNames,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/repo/forked.scala.html
                  HASH: 1eaa85f935e63b402215813078f37e0b7e0624d8
                  MATRIX: 764->1|1107->273|1170->309|1187->318|1271->394|1310->396|1339->400|1356->409|1399->444|1437->445|1468->450|1604->559|1643->560|1680->570|1696->577|1760->620|1796->629|1879->685|1918->686|1947->687|2009->705|2058->727|2074->734|2127->766|2157->769|2182->785|2213->795|2258->812|2275->819|2302->824|2332->826|2358->842|2390->852|2420->854|2446->870|2477->879|2508->882|2534->898|2565->907|2616->941|2655->942|2692->952|2708->959|2782->1012|2818->1021|2881->1057|2900->1067|2947->1093|2976->1094|3006->1097|3025->1107|3078->1139|3114->1148|3159->1163|3193->1170|3244->1195|3260->1202|3273->1206|3335->1230|3369->1237|3425->1266|3441->1273|3484->1295|3520->1304|3582->1339|3621->1340|3650->1341|3712->1359|3761->1381|3777->1388|3809->1399|3839->1402|3865->1407|3909->1424|3925->1431|3951->1436|3980->1438|4006->1443|4035->1445|4060->1449|4090->1452|4115->1456|4184->1495|4218->1499|4250->1501
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|27->10|27->10|28->11|28->11|28->11|29->12|29->12|29->12|29->12|29->12|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|32->15|32->15|33->16|33->16|33->16|34->17|35->18|35->18|35->18|35->18|35->18|35->18|35->18|36->19|37->20|38->21|40->23|40->23|40->23|40->23|41->24|42->25|42->25|42->25|43->26|43->26|43->26|43->26|43->26|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|47->30|48->31|49->32
                  -- GENERATED --
              */
          