package rponciano.ACTF;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Class created to look up user suggestions when entering text into a
 * TextField. These suggestions are based on a list that must be passed in the
 * constructor, in addition to the maximum number of suggestions that will be
 * displayed.
 * 
 * To work, just instantiate with the constructor passing the parameters: List
 * <String> containing the suggestions and int which will be the maximum number
 * of suggestions to be displayed at a time.
 * 
 * Credits:
 * https://stackoverflow.com/questions/36861056/javafx-textfield-auto-suggestions
 * https://gist.github.com/floralvikings/10290131
 * 
 * @author romuloponciano
 *
 */
public class AutoCompleteTextField extends TextField {

	private TreeSet<String> dados;
	private ContextMenu popMenu;
	private int maxSuggestions;

	public AutoCompleteTextField(List<String> dados, int maxSuggest) {
		super();
		this.setDados(new TreeSet<String>(dados));
		this.popMenu = new ContextMenu();
		this.maxSuggestions = maxSuggest;
		initListener();
	}

	private void initListener() {
		this.textProperty().addListener((obs, oldValue, newValue) -> {
			String typedText = this.getText();
			if (typedText == null || typedText.isEmpty()) {
				popMenu.hide();
			} else {
				List<String> poss = getPossibilities(typedText);
				if (!poss.isEmpty()) {
					populatePopup(poss);
					if (!popMenu.isShowing()) {
						popMenu.show(AutoCompleteTextField.this, Side.BOTTOM, 0, 0);
					}
				} else {
					popMenu.hide();
				}
			}
		});
	}

	private List<String> getPossibilities(String typedText) {
		return getDados().stream().filter(e -> e.toLowerCase().contains(typedText.toLowerCase()))
				.collect(Collectors.toList());
	}

	private void populatePopup(List<String> searchResult) {
		List<CustomMenuItem> menuItems = new LinkedList<>();
		int qtd = Math.min(searchResult.size(), maxSuggestions);
		for (int i = 0; i < qtd; i++) {
			menuItems.add(createMenuItem(searchResult.get(i)));
		}
		popMenu.getItems().clear();
		popMenu.getItems().addAll(menuItems);
	}

	private CustomMenuItem createMenuItem(String result) {
		Label lblItem = new Label(result);
		CustomMenuItem item = new CustomMenuItem(lblItem, true);
		item.setOnAction(onClickItemAction(result));
		return item;
	}

	private EventHandler<ActionEvent> onClickItemAction(String result) {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				setText(result);
			}
		};
	}

	public TreeSet<String> getDados() {
		return dados;
	}

	public void setDados(TreeSet<String> dados) {
		this.dados = dados;
	}
}
