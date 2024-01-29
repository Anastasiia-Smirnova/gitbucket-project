
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object repositories extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[gitbucket.core.model.Account,List[String],List[gitbucket.core.service.RepositoryService.RepositoryInfo],List[String],Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: gitbucket.core.model.Account, groupNames: List[String],
  repositories: List[gitbucket.core.service.RepositoryService.RepositoryInfo],
  extraMailAddresses: List[String],
  isGroupManager: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.account.html.main(account, groupNames, "repositories", extraMailAddresses, isGroupManager)/*6.107*/{_display_(Seq[Any](format.raw/*6.108*/("""
  """),_display_(if(repositories.isEmpty)/*7.28*/{_display_(Seq[Any](format.raw/*7.29*/("""
    """),format.raw/*8.5*/("""No repositories
  """)))}else/*9.10*/{_display_(Seq[Any](format.raw/*9.11*/("""
    """),_display_(/*10.6*/repositories/*10.18*/.map/*10.22*/ { repository =>_display_(Seq[Any](format.raw/*10.38*/("""
      """),format.raw/*11.7*/("""<div class="block">
        <div class="repository-icon">
          """),_display_(/*13.12*/gitbucket/*13.21*/.core.helper.html.repositoryicon(repository, true)),format.raw/*13.71*/("""
        """),format.raw/*14.9*/("""</div>
        <div class="repository-content">
          <div class="block-header">
            <a href=""""),_display_(/*17.23*/helpers/*17.30*/.url(repository)),format.raw/*17.46*/("""">"""),_display_(/*17.49*/repository/*17.59*/.name),format.raw/*17.64*/("""</a>
            """),_display_(if(repository.repository.isPrivate)/*18.49*/{_display_(Seq[Any](format.raw/*18.50*/("""
              """),format.raw/*19.15*/("""<i class="octicon octicon-lock"></i>
            """)))} else {null} ),format.raw/*20.14*/("""
          """),format.raw/*21.11*/("""</div>
          """),_display_(if(repository.repository.originUserName.isDefined)/*22.62*/{_display_(Seq[Any](format.raw/*22.63*/("""
            """),format.raw/*23.13*/("""<div class="small muted">forked from <a href=""""),_display_(/*23.60*/context/*23.67*/.path),format.raw/*23.72*/("""/"""),_display_(/*23.74*/repository/*23.84*/.repository.parentUserName),format.raw/*23.110*/("""/"""),_display_(/*23.112*/repository/*23.122*/.repository.parentRepositoryName),format.raw/*23.154*/("""">"""),_display_(/*23.157*/repository/*23.167*/.repository.parentUserName),format.raw/*23.193*/("""/"""),_display_(/*23.195*/repository/*23.205*/.repository.parentRepositoryName),format.raw/*23.237*/("""</a></div>
          """)))} else {null} ),format.raw/*24.12*/("""
          """),_display_(if(repository.repository.description.isDefined)/*25.59*/{_display_(Seq[Any](format.raw/*25.60*/("""
            """),format.raw/*26.13*/("""<div>"""),_display_(/*26.19*/repository/*26.29*/.repository.description),format.raw/*26.52*/("""</div>
          """)))} else {null} ),format.raw/*27.12*/("""
          """),format.raw/*28.11*/("""<div><span class="muted small">Updated """),_display_(/*28.51*/gitbucket/*28.60*/.core.helper.html.datetimeago(repository.repository.lastActivityDate)),format.raw/*28.129*/("""</span></div>
        </div>
      </div>
    """)))}),format.raw/*31.6*/("""
  """)))}),format.raw/*32.4*/("""
""")))}),format.raw/*33.2*/("""
"""))
      }
    }
  }

  def render(account:gitbucket.core.model.Account,groupNames:List[String],repositories:List[gitbucket.core.service.RepositoryService.RepositoryInfo],extraMailAddresses:List[String],isGroupManager:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,groupNames,repositories,extraMailAddresses,isGroupManager)(context)

  def f:((gitbucket.core.model.Account,List[String],List[gitbucket.core.service.RepositoryService.RepositoryInfo],List[String],Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,groupNames,repositories,extraMailAddresses,isGroupManager) => (context) => apply(account,groupNames,repositories,extraMailAddresses,isGroupManager)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/repositories.scala.html
                  HASH: 880d6fd8fad46cb31701c73652603f04776909a0
                  MATRIX: 742->1|1075->263|1138->299|1155->308|1260->404|1299->405|1353->433|1391->434|1422->439|1463->464|1501->465|1533->471|1554->483|1567->487|1621->503|1655->510|1751->579|1769->588|1840->638|1876->647|2010->754|2026->761|2063->777|2093->780|2112->790|2138->795|2218->848|2257->849|2300->864|2394->914|2433->925|2528->993|2567->994|2608->1007|2682->1054|2698->1061|2724->1066|2753->1068|2772->1078|2820->1104|2850->1106|2870->1116|2924->1148|2955->1151|2975->1161|3023->1187|3053->1189|3073->1199|3127->1231|3193->1253|3279->1312|3318->1313|3359->1326|3392->1332|3411->1342|3455->1365|3517->1383|3556->1394|3623->1434|3641->1443|3732->1512|3809->1559|3843->1563|3875->1565
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|24->7|24->7|25->8|26->9|26->9|27->10|27->10|27->10|27->10|28->11|30->13|30->13|30->13|31->14|34->17|34->17|34->17|34->17|34->17|34->17|35->18|35->18|36->19|37->20|38->21|39->22|39->22|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|41->24|42->25|42->25|43->26|43->26|43->26|43->26|44->27|45->28|45->28|45->28|45->28|48->31|49->32|50->33
                  -- GENERATED --
              */
          