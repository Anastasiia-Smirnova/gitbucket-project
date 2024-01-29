
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object forkrepository extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[gitbucket.core.service.RepositoryService.RepositoryInfo,Seq[(String, Boolean)],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  groupAndPerm: Seq[(String, Boolean)])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*4.1*/("""<h2 class="facebox-header">
  Where should we fork this repository?
  <a class="btn btn-default btn-sm" href=""""),_display_(/*6.44*/helpers/*6.51*/.url(repository)),format.raw/*6.67*/("""/network/members">Show forks</a>
</h2>
<form action=""""),_display_(/*8.16*/helpers/*8.23*/.url(repository)),format.raw/*8.39*/("""/fork" id="fork" method="post">
  <div class="block">
    """),_display_(/*10.6*/helpers/*10.13*/.avatar(context.loginAccount.get.userName, 24)),format.raw/*10.59*/(""" """),format.raw/*10.60*/("""<a href="javascript:void(0);" class="js-fork-owner-select-target">@"""),_display_(/*10.129*/context/*10.136*/.loginAccount.get.userName),format.raw/*10.162*/("""</a>
  </div>
  """),_display_(/*12.4*/for((groupName, isManager) <- groupAndPerm) yield /*12.47*/ {_display_(Seq[Any](format.raw/*12.49*/("""
    """),_display_(if(isManager)/*13.19*/ {_display_(Seq[Any](format.raw/*13.21*/("""
      """),format.raw/*14.7*/("""<div class="block js-fork-owner-select-target">
        """),_display_(/*15.10*/helpers/*15.17*/.avatar(groupName, 24)),format.raw/*15.39*/(""" """),format.raw/*15.40*/("""<a href="javascript:void(0);" class="js-fork-owner-select-target">@"""),_display_(/*15.109*/groupName),format.raw/*15.118*/("""</a>
      </div>
    """)))}else/*17.12*/{_display_(Seq[Any](format.raw/*17.13*/("""
      """),format.raw/*18.7*/("""<div class="block" title="You don't have permission to fork here.">
        """),_display_(/*19.10*/helpers/*19.17*/.avatar(groupName, 24)),format.raw/*19.39*/(""" """),format.raw/*19.40*/("""<span class="muted">@"""),_display_(/*19.63*/groupName),format.raw/*19.72*/("""</span>
      </div>
    """)))}),format.raw/*21.6*/("""
  """)))}),format.raw/*22.4*/("""
  """),format.raw/*23.3*/("""<input id="account" name="account" type="hidden" />
</form>
"""))
      }
    }
  }

  def render(repository:gitbucket.core.service.RepositoryService.RepositoryInfo,groupAndPerm:Seq[(String, Boolean)],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,groupAndPerm)(context)

  def f:((gitbucket.core.service.RepositoryService.RepositoryInfo,Seq[(String, Boolean)]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,groupAndPerm) => (context) => apply(repository,groupAndPerm)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/forkrepository.scala.html
                  HASH: f5b02012f0cc70ea091bf033aed61b00d3c13ede
                  MATRIX: 697->1|932->165|995->200|1132->311|1147->318|1183->334|1263->388|1278->395|1314->411|1399->470|1415->477|1482->523|1511->524|1607->593|1624->600|1672->626|1715->643|1774->686|1814->688|1860->707|1900->709|1934->716|2018->773|2034->780|2077->802|2106->803|2202->872|2233->881|2279->910|2318->911|2352->918|2456->995|2472->1002|2515->1024|2544->1025|2593->1048|2623->1057|2679->1083|2713->1087|2743->1090
                  LINES: 14->1|18->3|21->4|23->6|23->6|23->6|25->8|25->8|25->8|27->10|27->10|27->10|27->10|27->10|27->10|27->10|29->12|29->12|29->12|30->13|30->13|31->14|32->15|32->15|32->15|32->15|32->15|32->15|34->17|34->17|35->18|36->19|36->19|36->19|36->19|36->19|36->19|38->21|39->22|40->23
                  -- GENERATED --
              */
          