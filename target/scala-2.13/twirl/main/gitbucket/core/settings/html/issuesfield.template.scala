
package gitbucket.core.settings.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object issuesfield extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[gitbucket.core.model.CustomField,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(customField: gitbucket.core.model.CustomField):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<tr id="field-row-"""),_display_(/*2.20*/customField/*2.31*/.fieldId),format.raw/*2.39*/("""">
  <td>
    <div class="row" id="field-"""),_display_(/*4.33*/customField/*4.44*/.fieldId),format.raw/*4.52*/("""">
      <div class="col-md-4 strong">
        """),_display_(/*6.10*/customField/*6.21*/.fieldName),format.raw/*6.31*/("""
      """),format.raw/*7.7*/("""</div>
      <div class="col-md-4">
        """),_display_(/*9.10*/customField/*9.21*/.fieldType),format.raw/*9.31*/("""
        """),_display_(/*10.10*/customField/*10.21*/.constraints.map/*10.37*/ { constraints =>_display_(Seq[Any](format.raw/*10.54*/("""
          """),format.raw/*11.11*/("""("""),_display_(/*11.13*/constraints),format.raw/*11.24*/(""")
        """)))}),format.raw/*12.10*/("""
      """),format.raw/*13.7*/("""</div>
      <div class="col-md-2">
        """),_display_(if(customField.enableForIssues)/*15.41*/ {_display_(Seq[Any](format.raw/*15.43*/("""
          """),format.raw/*16.11*/("""Issues &nbsp;&nbsp;
        """)))} else {null} ),format.raw/*17.10*/("""
        """),_display_(if(customField.enableForPullRequests)/*18.47*/ {_display_(Seq[Any](format.raw/*18.49*/("""
          """),format.raw/*19.11*/("""Pull requests
        """)))} else {null} ),format.raw/*20.10*/("""
      """),format.raw/*21.7*/("""</div>
      <div class="col-md-2">
        <div class="pull-right">
          <a href="javascript:void(0);" onclick="editField("""),_display_(/*24.61*/customField/*24.72*/.fieldId),format.raw/*24.80*/(""")">Edit</a>
            &nbsp;&nbsp;
          <a href="javascript:void(0);" onclick="deleteField("""),_display_(/*26.63*/customField/*26.74*/.fieldId),format.raw/*26.82*/(""")">Delete</a>
        </div>
      </div>
    </div>
  </td>
</tr>
"""))
      }
    }
  }

  def render(customField:gitbucket.core.model.CustomField): play.twirl.api.HtmlFormat.Appendable = apply(customField)

  def f:((gitbucket.core.model.CustomField) => play.twirl.api.HtmlFormat.Appendable) = (customField) => apply(customField)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/settings/issuesfield.scala.html
                  HASH: 029e2514f406fbba3e4d00778923a4d9fa47997f
                  MATRIX: 616->1|757->49|802->68|821->79|849->87|917->129|936->140|964->148|1038->196|1057->207|1087->217|1120->224|1191->269|1210->280|1240->290|1277->300|1297->311|1322->327|1377->344|1416->355|1445->357|1477->368|1519->379|1553->386|1656->462|1696->464|1735->475|1808->504|1882->551|1922->553|1961->564|2028->587|2062->594|2218->723|2238->734|2267->742|2393->841|2413->852|2442->860
                  LINES: 14->1|19->2|19->2|19->2|19->2|21->4|21->4|21->4|23->6|23->6|23->6|24->7|26->9|26->9|26->9|27->10|27->10|27->10|27->10|28->11|28->11|28->11|29->12|30->13|32->15|32->15|33->16|34->17|35->18|35->18|36->19|37->20|38->21|41->24|41->24|41->24|43->26|43->26|43->26
                  -- GENERATED --
              */
          