
package gitbucket.core.wiki.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object compare extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template8[Option[String],String,String,Seq[gitbucket.core.util.JGitUtil.DiffInfo],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pageName: Option[String],
  from: String,
  to: String,
  diffs: Seq[gitbucket.core.util.JGitUtil.DiffInfo],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
    isEditable: Boolean,
  info: Option[Any])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*8.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*9.2*/gitbucket/*9.11*/.core.html.main(s"Compare Revisions - ${repository.owner}/${repository.name}", Some(repository))/*9.107*/{_display_(Seq[Any](format.raw/*9.108*/("""
  """),_display_(/*10.4*/gitbucket/*10.13*/.core.helper.html.information(info)),format.raw/*10.48*/("""
  """),_display_(/*11.4*/gitbucket/*11.13*/.core.html.menu("wiki", repository)/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/("""
    """),format.raw/*12.5*/("""<div class="pull-right">
      """),_display_(if(pageName.isDefined)/*13.30*/{_display_(Seq[Any](format.raw/*13.31*/("""
        """),format.raw/*14.9*/("""<a class="btn btn-small btn-default" href=""""),_display_(/*14.53*/helpers/*14.60*/.url(repository)),format.raw/*14.76*/("""/wiki/"""),_display_(/*14.83*/helpers/*14.90*/.urlEncode(pageName)),format.raw/*14.110*/("""">View Page</a>
        <a class="btn btn-small btn-default" href=""""),_display_(/*15.53*/helpers/*15.60*/.url(repository)),format.raw/*15.76*/("""/wiki/"""),_display_(/*15.83*/helpers/*15.90*/.urlEncode(pageName)),format.raw/*15.110*/("""/_history">Back to Page History</a>
      """)))}else/*16.14*/{_display_(Seq[Any](format.raw/*16.15*/("""
        """),format.raw/*17.9*/("""<a class="btn btn-small btn-default" href=""""),_display_(/*17.53*/helpers/*17.60*/.url(repository)),format.raw/*17.76*/("""/wiki/_history">Back to Wiki History</a>
      """)))}),format.raw/*18.8*/("""
      """),_display_(if(isEditable)/*19.22*/ {_display_(Seq[Any](format.raw/*19.24*/("""
        """),_display_(if(pageName.isDefined)/*20.32*/ {_display_(Seq[Any](format.raw/*20.34*/("""
          """),format.raw/*21.11*/("""<a href=""""),_display_(/*21.21*/helpers/*21.28*/.url(repository)),format.raw/*21.44*/("""/wiki/"""),_display_(/*21.51*/helpers/*21.58*/.urlEncode(pageName)),format.raw/*21.78*/("""/_revert/"""),_display_(/*21.88*/from),format.raw/*21.92*/("""..."""),_display_(/*21.96*/to),format.raw/*21.98*/("""" class="btn btn-danger">Revert Changes</a>
        """)))}else/*22.16*/{_display_(Seq[Any](format.raw/*22.17*/("""
          """),format.raw/*23.11*/("""<a href=""""),_display_(/*23.21*/helpers/*23.28*/.url(repository)),format.raw/*23.44*/("""/wiki/_revert/"""),_display_(/*23.59*/from),format.raw/*23.63*/("""..."""),_display_(/*23.67*/to),format.raw/*23.69*/("""" class="btn btn-danger">Revert Changes</a>
        """)))}),format.raw/*24.10*/("""
      """)))} else {null} ),format.raw/*25.8*/("""
    """),format.raw/*26.5*/("""</div>
    <h1 class="body-title"><span class="muted">Compare Revisions</span></h1>
    """),_display_(/*28.6*/gitbucket/*28.15*/.core.helper.html.diff(diffs, repository, None, None, false, None, false, false)),format.raw/*28.95*/("""
  """)))}),format.raw/*29.4*/("""
""")))}),format.raw/*30.2*/("""
"""))
      }
    }
  }

  def render(pageName:Option[String],from:String,to:String,diffs:Seq[gitbucket.core.util.JGitUtil.DiffInfo],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,isEditable:Boolean,info:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(pageName,from,to,diffs,repository,isEditable,info)(context)

  def f:((Option[String],String,String,Seq[gitbucket.core.util.JGitUtil.DiffInfo],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (pageName,from,to,diffs,repository,isEditable,info) => (context) => apply(pageName,from,to,diffs,repository,isEditable,info)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/wiki/compare.scala.html
                  HASH: d3d94e93a285b59c830e73f693b48184e1cb136c
                  MATRIX: 757->1|1109->282|1172->318|1189->327|1294->423|1333->424|1363->428|1381->437|1437->472|1467->476|1485->485|1529->520|1568->521|1600->526|1681->580|1720->581|1756->590|1827->634|1843->641|1880->657|1914->664|1930->671|1972->691|2067->759|2083->766|2120->782|2154->789|2170->796|2212->816|2278->865|2317->866|2353->875|2424->919|2440->926|2477->942|2555->990|2604->1012|2644->1014|2703->1046|2743->1048|2782->1059|2819->1069|2835->1076|2872->1092|2906->1099|2922->1106|2963->1126|3000->1136|3025->1140|3056->1144|3079->1146|3155->1205|3194->1206|3233->1217|3270->1227|3286->1234|3323->1250|3365->1265|3390->1269|3421->1273|3444->1275|3528->1328|3579->1336|3611->1341|3726->1430|3744->1439|3845->1519|3879->1523|3911->1525
                  LINES: 14->1|23->8|26->9|26->9|26->9|26->9|27->10|27->10|27->10|28->11|28->11|28->11|28->11|29->12|30->13|30->13|31->14|31->14|31->14|31->14|31->14|31->14|31->14|32->15|32->15|32->15|32->15|32->15|32->15|33->16|33->16|34->17|34->17|34->17|34->17|35->18|36->19|36->19|37->20|37->20|38->21|38->21|38->21|38->21|38->21|38->21|38->21|38->21|38->21|38->21|38->21|39->22|39->22|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|41->24|42->25|43->26|45->28|45->28|45->28|46->29|47->30
                  -- GENERATED --
              */
          