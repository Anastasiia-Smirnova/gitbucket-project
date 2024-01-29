
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object preferences extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[gitbucket.core.model.Account,String,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: gitbucket.core.model.Account, currentTheme: String)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/gitbucket/*2.11*/.core.html.main("Preferences", highlighterTheme = currentTheme)/*2.74*/{_display_(Seq[Any](format.raw/*2.75*/("""
  """),_display_(/*3.4*/gitbucket/*3.13*/.core.account.html.menu("preferences", context.loginAccount.get.userName, false)/*3.93*/{_display_(Seq[Any](format.raw/*3.94*/("""
    """),format.raw/*4.5*/("""<form method="POST" action=""""),_display_(/*4.34*/context/*4.41*/.path),format.raw/*4.46*/("""/"""),_display_(/*4.48*/account/*4.55*/.userName),format.raw/*4.64*/("""/_preferences/highlighter" validate="true" autocomplete="off">
      <div class="panel panel-default">
        <div class="panel-heading strong">Syntax Highlighter Theme</div>
        <div class="panel-body">
          <div class="row">
            <div class="col-md-4">
              <fieldset class="form-group">
                <label for="highlighterTheme" class="strong">Theme</label>
                <select id="highlighterTheme" name="highlighterTheme" class="form-control">
                """),_display_(/*13.18*/Seq(
                  ("atelier-cave-dark", "Atelier Cave Dark"),
                  ("atelier-cave-light", "Atelier Cave Light"),
                  ("atelier-dune-dark", "Atelier Dune Dark"),
                  ("atelier-dune-light", "Atelier Dune Light"),
                  ("atelier-estuary-dark", "Atelier Estuary Dark"),
                  ("atelier-estuary-light", "Atelier Estuary Light"),
                  ("atelier-forest-dark", "Atelier Forest Dark"),
                  ("atelier-forest-light", "Atelier Forest Light"),
                  ("atelier-heath-dark", "Atelier Heath Dark"),
                  ("atelier-heath-light", "Atelier Heath Light"),
                  ("atelier-lakeside-dark", "Atelier Lakeside Dark"),
                  ("atelier-lakeside-light", "Atelier Lakeside Light"),
                  ("atelier-plateau-dark", "Atelier Plateau Dark"),
                  ("atelier-plateau-light", "Atelier Plateau Light"),
                  ("atelier-savanna-dark", "Atelier Savanna Dark"),
                  ("atelier-savanna-light", "Atelier Savanna Light"),
                  ("atelier-seaside-dark", "Atelier Seaside Dark"),
                  ("atelier-seaside-light", "Atelier Seaside Light"),
                  ("atelier-sulphurpool-dark", "Atelier Sulphurpool Dark"),
                  ("atelier-sulphurpool-light", "Atelier Sulphurpool Light"),
                  ("github", "GitHub"),
                  ("github-v2", "GitHub v2"),
                  ("hemisu-dark", "Hemisu Dark"),
                  ("hemisu-light", "Hemisu Light"),
                  ("tomorrow", "Tomorrow"),
                  ("tomorrow-night", "Tomorrow Night"),
                  ("tomorrow-night-blue", "Tomorrow Night Blue"),
                  ("tomorrow-night-bright", "Tomorrow Night Bright"),
                  ("tomorrow-night-eighties", "Tomorrow Night Eighties"),
                  ("vibrant-ink", "Vibrant Ink")
                )/*44.18*/.map/*44.22*/{ theme =>_display_(Seq[Any](format.raw/*44.32*/("""
                  """),format.raw/*45.19*/("""<option value=""""),_display_(/*45.35*/theme/*45.40*/._1),format.raw/*45.43*/("""""""),_display_(if(theme._1 == currentTheme)/*45.73*/{_display_(Seq[Any](format.raw/*45.74*/(""" """),format.raw/*45.75*/("""selected=""""")))} else {null} ),format.raw/*45.87*/(""">"""),_display_(/*45.89*/theme/*45.94*/._2),format.raw/*45.97*/("""</option>
                """)))}),format.raw/*46.18*/("""
                """),format.raw/*47.17*/("""</select>
              </fieldset>
              <input type="submit" class="btn btn-success" value="Save"/>
            </div>
            <div class="col-md-8">
              <div style="margin: 5px">
                <pre class="prettyprint linenums">"""),_display_(/*53.52*/{
                  """#include <iostream>
                    |
                    |using namespace std;
                    |
                    |int main(){
                    |  cout << 'Hello world.' << endl;
                    |  return 0;
                    |}""".stripMargin}),format.raw/*61.39*/("""
                """),format.raw/*62.17*/("""</pre>
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
    <script>
            $(function()"""),format.raw/*70.25*/("""{"""),format.raw/*70.26*/("""
              """),format.raw/*71.15*/("""$('#highlighterTheme').change(function(evt) """),format.raw/*71.59*/("""{"""),format.raw/*71.60*/("""
                """),format.raw/*72.17*/("""var that = $(evt.target);
                var themeCss = $('link[rel="stylesheet"][href*="color-themes-for-google-code-prettify"]');
                var oldVal = new RegExp('color-themes-for-google-code-prettify/(.*?).min.css').exec(themeCss.attr('href'))[1];
                themeCss.attr('href', themeCss.attr('href').replace(oldVal, that.val()));
                $(document.body).removeClass(oldVal).addClass(that.val());
              """),format.raw/*77.15*/("""}"""),format.raw/*77.16*/(""");
              prettyPrint();
            """),format.raw/*79.13*/("""}"""),format.raw/*79.14*/(""");
    </script>
  """)))}),format.raw/*81.4*/("""
""")))}),format.raw/*82.2*/("""
"""))
      }
    }
  }

  def render(account:gitbucket.core.model.Account,currentTheme:String,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,currentTheme)(context)

  def f:((gitbucket.core.model.Account,String) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,currentTheme) => (context) => apply(account,currentTheme)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/preferences.scala.html
                  HASH: baa49b24344c513b8ba65a4acad4df489a6f52a2
                  MATRIX: 652->1|860->117|877->126|948->189|986->190|1015->194|1032->203|1120->283|1158->284|1189->289|1244->318|1259->325|1284->330|1312->332|1327->339|1356->348|1883->848|3825->2781|3838->2785|3886->2795|3933->2814|3976->2830|3990->2835|4014->2838|4071->2868|4110->2869|4139->2870|4195->2882|4224->2884|4238->2889|4262->2892|4320->2919|4365->2936|4647->3191|4956->3479|5001->3496|5170->3637|5199->3638|5242->3653|5314->3697|5343->3698|5388->3715|5855->4154|5884->4155|5956->4199|5985->4200|6035->4220|6067->4222
                  LINES: 14->1|19->2|19->2|19->2|19->2|20->3|20->3|20->3|20->3|21->4|21->4|21->4|21->4|21->4|21->4|21->4|30->13|61->44|61->44|61->44|62->45|62->45|62->45|62->45|62->45|62->45|62->45|62->45|62->45|62->45|62->45|63->46|64->47|70->53|78->61|79->62|87->70|87->70|88->71|88->71|88->71|89->72|94->77|94->77|96->79|96->79|98->81|99->82
                  -- GENERATED --
              */
          