
package gitbucket.core.issues.labels.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object label extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[gitbucket.core.model.Label,Map[String, Int],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(label: gitbucket.core.model.Label,
  counts: Map[String, Int],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*6.1*/("""<tr id="label-row-"""),_display_(/*6.20*/label/*6.25*/.labelId),format.raw/*6.33*/("""">
  <td style="padding-top: 15px; padding-bottom: 15px;">
    <div class="milestone row" id="label-"""),_display_(/*8.43*/label/*8.48*/.labelId),format.raw/*8.56*/("""">
      <div class="col-md-8">
        <div>
          <a href=""""),_display_(/*11.21*/helpers/*11.28*/.url(repository)),format.raw/*11.44*/("""/issues?labels="""),_display_(/*11.60*/helpers/*11.67*/.urlEncode(label.labelName)),format.raw/*11.94*/("""" id="label-row-content-"""),_display_(/*11.119*/label/*11.124*/.labelId),format.raw/*11.132*/("""">
            <span style="background-color: #"""),_display_(/*12.46*/label/*12.51*/.color),format.raw/*12.57*/("""; color: #"""),_display_(/*12.68*/label/*12.73*/.fontColor),format.raw/*12.83*/("""; padding: 8px; border-radius: 4px;">
              <i class="octicon octicon-tag" style="color: #"""),_display_(/*13.62*/label/*13.67*/.fontColor),format.raw/*13.77*/(""";"></i>
              """),_display_(/*14.16*/label/*14.21*/.labelName),format.raw/*14.31*/("""
            """),format.raw/*15.13*/("""</span>
          </a>
        </div>
      </div>
      <div class=""""),_display_(if(hasWritePermission)/*19.42*/{_display_(Seq[Any](format.raw/*19.43*/("""col-md-2""")))}else/*19.58*/{_display_(Seq[Any](format.raw/*19.59*/("""col-md-4""")))}),format.raw/*19.68*/("""">
        <div class="pull-right">
          <span class="muted">"""),_display_(/*21.32*/counts/*21.38*/.get(label.labelName).getOrElse(0)),format.raw/*21.72*/(""" """),format.raw/*21.73*/("""open issues</span>
        </div>
      </div>
      """),_display_(if(hasWritePermission)/*24.30*/{_display_(Seq[Any](format.raw/*24.31*/("""
        """),format.raw/*25.9*/("""<div class="col-md-2">
          <div class="pull-right">
            <a href="javascript:void(0);" onclick="editLabel("""),_display_(/*27.63*/label/*27.68*/.labelId),format.raw/*27.76*/(""")">Edit</a>
            &nbsp;&nbsp;
            <a href="javascript:void(0);" onclick="deleteLabel("""),_display_(/*29.65*/label/*29.70*/.labelId),format.raw/*29.78*/(""")">Delete</a>
          </div>
        </div>
      """)))} else {null} ),format.raw/*32.8*/("""
    """),format.raw/*33.5*/("""</div>
  </td>
</tr>
"""))
      }
    }
  }

  def render(label:gitbucket.core.model.Label,counts:Map[String, Int],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(label,counts,repository,hasWritePermission)(context)

  def f:((gitbucket.core.model.Label,Map[String, Int],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (label,counts,repository,hasWritePermission) => (context) => apply(label,counts,repository,hasWritePermission)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/labels/label.scala.html
                  HASH: 0268fe2d3c846cf2c9d33b235ff57dce62e883f3
                  MATRIX: 724->1|1015->221|1078->256|1123->275|1136->280|1164->288|1291->389|1304->394|1332->402|1425->468|1441->475|1478->491|1521->507|1537->514|1585->541|1638->566|1653->571|1683->579|1758->627|1772->632|1799->638|1837->649|1851->654|1882->664|2008->763|2022->768|2053->778|2103->801|2117->806|2148->816|2189->829|2308->921|2347->922|2379->937|2418->938|2458->947|2552->1014|2567->1020|2622->1054|2651->1055|2754->1131|2793->1132|2829->1141|2976->1261|2990->1266|3019->1274|3147->1375|3161->1380|3190->1388|3286->1441|3318->1446
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|25->8|25->8|25->8|28->11|28->11|28->11|28->11|28->11|28->11|28->11|28->11|28->11|29->12|29->12|29->12|29->12|29->12|29->12|30->13|30->13|30->13|31->14|31->14|31->14|32->15|36->19|36->19|36->19|36->19|36->19|38->21|38->21|38->21|38->21|41->24|41->24|42->25|44->27|44->27|44->27|46->29|46->29|46->29|49->32|50->33
                  -- GENERATED --
              */
          