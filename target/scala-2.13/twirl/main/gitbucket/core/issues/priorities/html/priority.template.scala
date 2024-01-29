
package gitbucket.core.issues.priorities.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object priority extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[gitbucket.core.model.Priority,Map[String, Int],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(priority: gitbucket.core.model.Priority,
  counts: Map[String, Int],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*6.1*/("""<tr id="priority-row-"""),_display_(/*6.23*/priority/*6.31*/.priorityId),format.raw/*6.42*/("""" class="priority-row">
  <td style="padding-top: 15px; padding-bottom: 15px;">
    <div class="milestone row" id="priority-"""),_display_(/*8.46*/priority/*8.54*/.priorityId),format.raw/*8.65*/("""">
      <div class="col-md-2">
        """),_display_(if(hasWritePermission)/*10.32*/ {_display_(Seq[Any](format.raw/*10.34*/("""
        """),format.raw/*11.9*/("""<div class="pull-left priority-sort-handle" style="margin-top: 3px"><i class="octicon octicon-grabber"></i></div>
        """)))} else {null} ),format.raw/*12.10*/("""
        """),format.raw/*13.9*/("""<div>
          <a href=""""),_display_(/*14.21*/helpers/*14.28*/.url(repository)),format.raw/*14.44*/("""/issues?priority="""),_display_(/*14.62*/helpers/*14.69*/.urlEncode(priority.priorityName)),format.raw/*14.102*/("""&state=open" id="priority-row-content-"""),_display_(/*14.141*/priority/*14.149*/.priorityId),format.raw/*14.160*/("""">
            <span style="background-color: #"""),_display_(/*15.46*/priority/*15.54*/.color),format.raw/*15.60*/("""; color: #"""),_display_(/*15.71*/priority/*15.79*/.fontColor),format.raw/*15.89*/("""; padding: 8px; border-radius: 4px;">
              <i class="octicon octicon-flame" style="color: #"""),_display_(/*16.64*/priority/*16.72*/.fontColor),format.raw/*16.82*/(""";"></i>&nbsp;"""),_display_(/*16.96*/priority/*16.104*/.priorityName),format.raw/*16.117*/("""
            """),format.raw/*17.13*/("""</span>
          </a>
        </div>
      </div>
      <div class=""""),_display_(if(hasWritePermission)/*21.42*/{_display_(Seq[Any](format.raw/*21.43*/("""col-md-6""")))}else/*21.58*/{_display_(Seq[Any](format.raw/*21.59*/("""col-md-8""")))}),format.raw/*21.68*/("""">
        <span>"""),_display_(/*22.16*/priority/*22.24*/.description.getOrElse("")),format.raw/*22.50*/("""</span>
      </div>
      <div class="col-md-1">
        <div class="pull-right">
          """),_display_(if(hasWritePermission)/*26.34*/{_display_(Seq[Any](format.raw/*26.35*/("""
            """),format.raw/*27.13*/("""<a href="javascript:void(0);" onclick="setDefaultPriority("""),_display_(/*27.72*/priority/*27.80*/.priorityId),format.raw/*27.91*/(""")" data-id=""""),_display_(/*27.104*/priority/*27.112*/.priorityId),format.raw/*27.123*/("""" data-default=""""),_display_(/*27.140*/priority/*27.148*/.isDefault),format.raw/*27.158*/("""" class="priority-default"""),_display_(if(priority.isDefault)/*27.206*/{_display_(Seq[Any](format.raw/*27.207*/(""" """),format.raw/*27.208*/("""priority-default-selected""")))} else {null} ),format.raw/*27.234*/("""" title=""""),_display_(if(priority.isDefault)/*27.266*/{_display_(Seq[Any](format.raw/*27.267*/("""Unset as default""")))}else/*27.290*/{_display_(Seq[Any](format.raw/*27.291*/("""Set as default""")))}),format.raw/*27.306*/(""""><i class="octicon octicon-star"></i></a>
          """)))}else if(priority.isDefault)/*28.40*/ {_display_(Seq[Any](format.raw/*28.42*/("""
            """),format.raw/*29.13*/("""<i class="octicon octicon-star priority-default priority-default-selected" title="Default"></i>
          """)))} else {null} ),format.raw/*30.12*/("""
        """),format.raw/*31.9*/("""</div>
      </div>
      <div class="col-md-1">
        <div class="pull-right">
          <span class="muted">"""),_display_(/*35.32*/counts/*35.38*/.get(priority.priorityName).getOrElse(0)),format.raw/*35.78*/(""" """),format.raw/*35.79*/("""open issues</span>
        </div>
      </div>
      """),_display_(if(hasWritePermission)/*38.30*/{_display_(Seq[Any](format.raw/*38.31*/("""
        """),format.raw/*39.9*/("""<div class="col-md-2">
          <div class="pull-right">
            <a href="javascript:void(0);" onclick="editPriority("""),_display_(/*41.66*/priority/*41.74*/.priorityId),format.raw/*41.85*/(""")">Edit</a>
            &nbsp;&nbsp;
            <a href="javascript:void(0);" onclick="deletePriority("""),_display_(/*43.68*/priority/*43.76*/.priorityId),format.raw/*43.87*/(""")">Delete</a>
          </div>
        </div>
      """)))} else {null} ),format.raw/*46.8*/("""
    """),format.raw/*47.5*/("""</div>
  </td>
</tr>
"""))
      }
    }
  }

  def render(priority:gitbucket.core.model.Priority,counts:Map[String, Int],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(priority,counts,repository,hasWritePermission)(context)

  def f:((gitbucket.core.model.Priority,Map[String, Int],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (priority,counts,repository,hasWritePermission) => (context) => apply(priority,counts,repository,hasWritePermission)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/priorities/priority.scala.html
                  HASH: 962c599e5eb64f157ab95606e39776abf539c964
                  MATRIX: 734->1|1031->227|1094->262|1142->284|1158->292|1189->303|1340->428|1356->436|1387->447|1477->510|1517->512|1553->521|1720->644|1756->653|1809->679|1825->686|1862->702|1907->720|1923->727|1978->760|2045->799|2063->807|2096->818|2171->866|2188->874|2215->880|2253->891|2270->899|2301->909|2429->1010|2446->1018|2477->1028|2518->1042|2536->1050|2571->1063|2612->1076|2731->1168|2770->1169|2802->1184|2841->1185|2881->1194|2926->1212|2943->1220|2990->1246|3133->1362|3172->1363|3213->1376|3299->1435|3316->1443|3348->1454|3389->1467|3407->1475|3440->1486|3485->1503|3503->1511|3535->1521|3611->1569|3651->1570|3681->1571|3752->1597|3812->1629|3852->1630|3893->1653|3933->1654|3980->1669|4080->1751|4120->1753|4161->1766|4312->1873|4348->1882|4488->1995|4503->2001|4564->2041|4593->2042|4696->2118|4735->2119|4771->2128|4921->2251|4938->2259|4970->2270|5101->2374|5118->2382|5150->2393|5246->2446|5278->2451
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|25->8|25->8|25->8|27->10|27->10|28->11|29->12|30->13|31->14|31->14|31->14|31->14|31->14|31->14|31->14|31->14|31->14|32->15|32->15|32->15|32->15|32->15|32->15|33->16|33->16|33->16|33->16|33->16|33->16|34->17|38->21|38->21|38->21|38->21|38->21|39->22|39->22|39->22|43->26|43->26|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|45->28|45->28|46->29|47->30|48->31|52->35|52->35|52->35|52->35|55->38|55->38|56->39|58->41|58->41|58->41|60->43|60->43|60->43|63->46|64->47
                  -- GENERATED --
              */
          