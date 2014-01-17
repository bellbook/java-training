package interpret.gui;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class ShowDialog extends Stage {

    private static final int WIDTH  = 800;
    private static final int HEIGHT = 600;

    private String[] titles = new String[]{ "Field", "Constructor", "Method" };

    public ShowDialog(final Class<?> clazz) {

        initStyle(StageStyle.DECORATED);
        initModality(Modality.WINDOW_MODAL);
        setTitle("Class Dialog");
        setWidth(WIDTH);
        setHeight(HEIGHT);

        settingSecene(null, clazz);
    }

    public ShowDialog(final String name, final Object obj) {

        initStyle(StageStyle.DECORATED);
        initModality(Modality.WINDOW_MODAL);
        setTitle("Object Dialog");
        setWidth(WIDTH);
        setHeight(HEIGHT);

        if (obj.getClass().isArray())
            settingSecene(name, (Object[]) obj);
        else
            settingSecene(name, obj);
    }

    private void settingSecene(String name, Class<?> clazz) {

        Lists lists = parse(null, clazz);
        VBox vbox = createPage(name, clazz, lists);

        AnchorPane anchor = new AnchorPane();
        AnchorPane.setTopAnchor(vbox, 10.0);
        AnchorPane.setRightAnchor(vbox, 10.0);
        AnchorPane.setBottomAnchor(vbox, 10.0);
        AnchorPane.setLeftAnchor(vbox, 10.0);
        anchor.getChildren().addAll(vbox);

        Scene scene = new Scene(anchor);
        setScene(scene);
    }

    private void settingSecene(String name, Object obj) {

        Lists lists = parse(obj, obj.getClass());
        VBox vbox = createPage(name, obj.getClass(), lists);

        AnchorPane anchor = new AnchorPane();
        AnchorPane.setTopAnchor(vbox, 10.0);
        AnchorPane.setRightAnchor(vbox, 10.0);
        AnchorPane.setBottomAnchor(vbox, 10.0);
        AnchorPane.setLeftAnchor(vbox, 10.0);
        anchor.getChildren().addAll(vbox);

        Scene scene = new Scene(anchor);
        setScene(scene);
    }

    private void settingSecene(final String name, final Object[] array) {

        Pagination pagination = new Pagination(array.length, 0);
        pagination.setStyle("-fx-border-color:red;");
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                if(array[pageIndex] == null) {
                    return createNullPage(name + "[" + pageIndex + "]");
                }
                else {
                    Lists lists = parse(array[pageIndex], array[pageIndex].getClass());
                    return createPage(name + "[" + pageIndex + "]", array[pageIndex].getClass(), lists);
                }
            }
        });

        AnchorPane anchor = new AnchorPane();
        AnchorPane.setTopAnchor(pagination, 10.0);
        AnchorPane.setRightAnchor(pagination, 10.0);
        AnchorPane.setBottomAnchor(pagination, 10.0);
        AnchorPane.setLeftAnchor(pagination, 10.0);
        anchor.getChildren().addAll(pagination);

        Scene scene = new Scene(anchor);
        setScene(scene);
    }

    private Lists parse(Object obj, Class<?> clazz) {

        List<FieldProperty> fieldList = new ArrayList<FieldProperty>();
        List<ConstructorProperty> constructorList = new ArrayList<ConstructorProperty>();
        List<MethodProperty> methodList = new ArrayList<MethodProperty>();

        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            FieldProperty fProp = new FieldProperty()
            .setModifier(Modifier.toString(f.getModifiers()))
            .setType(f.getType().toString())
            .setName(f.getName());

            f.setAccessible(true);

            if (obj != null || Modifier.isStatic(f.getModifiers())) {
                try {
                    Object o = f.get(obj);
                    if (o != null)
                        fProp.setValue(o.toString());
                } catch (IllegalArgumentException e) {
                } catch (IllegalAccessException e) {
                }
            }

            fieldList.add(fProp);
        }

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            ConstructorProperty cProp = new ConstructorProperty()
            .setModifier(Modifier.toString(c.getModifiers()))
            .setName(c.getName())
            .setParameter(Arrays.toString(c.getGenericParameterTypes()))
            .setException(Arrays.toString(c.getGenericExceptionTypes()));
            constructorList.add(cProp);
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            MethodProperty mProp = new MethodProperty()
            .setModifier(Modifier.toString(m.getModifiers()))
            .setType(m.getGenericReturnType().toString())
            .setName(m.getName())
            .setParameter(Arrays.toString(m.getGenericParameterTypes()))
            .setException(Arrays.toString(m.getGenericExceptionTypes()));
            methodList.add(mProp);
        }

        Lists lists = new Lists();
        lists.fieldList = fieldList;
        lists.constructorList = constructorList;
        lists.methodList = methodList;

        return lists;
    }

    private VBox createNullPage(String name) {

        // --------------------
        // setting Label
        // --------------------
        Label label = new Label(name + " = " + null);
        label.setFont(new Font("Arial", 20));

        VBox vbox = VBoxBuilder.create()
                .spacing(5)
                .padding(new Insets(10, 0, 0, 10))
                .build();

        vbox.getChildren().addAll(
                label
        );

        return vbox;
    }

    private VBox createPage(String name, Class<?> clazz, Lists lists) {

        // --------------------
        // setting Label
        // --------------------
        Label label;
        if (name == null)
            label = new Label(clazz.toString());
        else
            label = new Label(name + " = " + clazz.toString());
        label.setFont(new Font("Arial", 20));

        // --------------------
        // setting TableView
        // --------------------
        TableView<FieldProperty> fieldTable = createFieldTable(lists.fieldList);
        TableView<ConstructorProperty> constructorTable = createConstructorTable(lists.constructorList);
        TableView<MethodProperty> methodTable = createMethodTable(lists.methodList);

        // --------------------
        // setting TitledPane
        // --------------------
        @SuppressWarnings("rawtypes")
        TableView[] tables = new TableView[] { fieldTable, constructorTable, methodTable };
        TitledPane[] titledPane = new TitledPane[titles.length];
        for (int i = 0; i < titles.length; i++)
            titledPane[i] = new TitledPane(titles[i], tables[i]);

        // --------------------
        // setting Accordion
        // --------------------
        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(titledPane);
        accordion.setExpandedPane(titledPane[0]);

        // --------------------
        // setting VBox
        // --------------------
        VBox vbox = VBoxBuilder.create()
                               .spacing(5)
                               .padding(new Insets(10, 0, 0, 10))
                               .build();

        vbox.getChildren().addAll(
                label,
                accordion
        );

        return vbox;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private TableView<FieldProperty> createFieldTable(List<FieldProperty> fieldList) {

        TableView<FieldProperty> fieldTable = new TableView<FieldProperty>();

        TableColumn modifierCol = new TableColumn("Modifier");
        modifierCol.setMinWidth(100);
        modifierCol.setCellValueFactory(new PropertyValueFactory("modifier"));

        TableColumn typeCol = new TableColumn("Type");
        typeCol.setMinWidth(100);
        typeCol.setCellValueFactory(new PropertyValueFactory("type"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));

        TableColumn valueCol = new TableColumn("Value");
        valueCol.setMinWidth(100);
        valueCol.setCellValueFactory(new PropertyValueFactory("value"));

        ObservableList<FieldProperty> data = FXCollections.observableList(fieldList);
        fieldTable.setItems(data);
        fieldTable.getColumns().addAll(modifierCol, typeCol, nameCol, valueCol);

        fieldTable.setMinWidth(750);
        fieldTable.setMinHeight(300);

        return fieldTable;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private TableView<ConstructorProperty> createConstructorTable(List<ConstructorProperty> constructorList) {

        TableView<ConstructorProperty> constructorTable = new TableView<ConstructorProperty>();

        TableColumn modifierCol = new TableColumn("Modifier");
        modifierCol.setMinWidth(100);
        modifierCol.setCellValueFactory(new PropertyValueFactory("modifier"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));

        TableColumn parameterCol = new TableColumn("Parameter");
        parameterCol.setMinWidth(100);
        parameterCol.setCellValueFactory(new PropertyValueFactory("parameter"));

        TableColumn exceptionCol = new TableColumn("Exception");
        exceptionCol.setMinWidth(100);
        exceptionCol.setCellValueFactory(new PropertyValueFactory("exception"));

        ObservableList<ConstructorProperty> data = FXCollections.observableList(constructorList);
        constructorTable.setItems(data);
        constructorTable.getColumns().addAll(modifierCol, nameCol, parameterCol, exceptionCol);

        constructorTable.setMinWidth(750);
        constructorTable.setMinHeight(300);

        return constructorTable;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private TableView<MethodProperty> createMethodTable(List<MethodProperty> methodList) {

        TableView<MethodProperty> methodTable = new TableView<MethodProperty>();

        TableColumn modifierCol = new TableColumn("Modifier");
        modifierCol.setMinWidth(100);
        modifierCol.setCellValueFactory(new PropertyValueFactory("modifier"));

        TableColumn typeCol = new TableColumn("Type");
        typeCol.setMinWidth(100);
        typeCol.setCellValueFactory(new PropertyValueFactory("type"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));

        TableColumn parameterCol = new TableColumn("Parameter");
        parameterCol.setMinWidth(100);
        parameterCol.setCellValueFactory(new PropertyValueFactory("parameter"));

        TableColumn exceptionCol = new TableColumn("Exception");
        exceptionCol.setMinWidth(100);
        exceptionCol.setCellValueFactory(new PropertyValueFactory("exception"));

        ObservableList<MethodProperty> data = FXCollections.observableList(methodList);
        methodTable.setItems(data);
        methodTable.getColumns().addAll(modifierCol, typeCol, nameCol, parameterCol, exceptionCol);

        methodTable.setMinWidth(750);
        methodTable.setMinHeight(300);

        return methodTable;
    }

    class Lists {
        List<FieldProperty> fieldList;
        List<ConstructorProperty> constructorList;
        List<MethodProperty> methodList;
    }

    public class FieldProperty {

        private SimpleStringProperty modifier = new SimpleStringProperty();
        private SimpleStringProperty type = new SimpleStringProperty();
        private SimpleStringProperty name = new SimpleStringProperty();
        private SimpleStringProperty value = new SimpleStringProperty();

        public String getModifier() {
            return modifier.get();
        }

        public FieldProperty setModifier(String modifier) {
            this.modifier.set(modifier);
            return this;
        }

        public String getType() {
            return type.get();
        }

        public FieldProperty setType(String type) {
            this.type.set(type);
            return this;
        }

        public String getName() {
            return name.get();
        }

        public FieldProperty setName(String name) {
            this.name.set(name);
            return this;
        }

        public String getValue() {
            return value.get();
        }

        public FieldProperty setValue(String value) {
            this.value.set(value);
            return this;
        }

    }

    public class ConstructorProperty {

        private SimpleStringProperty modifier = new SimpleStringProperty();
        private SimpleStringProperty name = new SimpleStringProperty();
        private SimpleStringProperty parameter = new SimpleStringProperty();
        private SimpleStringProperty exception = new SimpleStringProperty();

        public String getModifier() {
            return modifier.get();
        }

        public ConstructorProperty setModifier(String modifier) {
            this.modifier.set(modifier);
            return this;
        }

        public String getName() {
            return name.get();
        }

        public ConstructorProperty setName(String name) {
            this.name.set(name);
            return this;
        }

        public String getParameter() {
            return parameter.get();
        }

        public ConstructorProperty setParameter(String parameter) {
            this.parameter.set(parameter);
            return this;
        }

        public String getException() {
            return exception.get();
        }

        public ConstructorProperty setException(String exception) {
            this.exception.set(exception);
            return this;
        }

    }

    public class MethodProperty {

        private SimpleStringProperty modifier = new SimpleStringProperty();
        private SimpleStringProperty type = new SimpleStringProperty();
        private SimpleStringProperty name = new SimpleStringProperty();
        private SimpleStringProperty parameter = new SimpleStringProperty();
        private SimpleStringProperty exception = new SimpleStringProperty();

        public String getModifier() {
            return modifier.get();
        }

        public MethodProperty setModifier(String modifier) {
            this.modifier.set(modifier);
            return this;
        }

        public String getType() {
            return type.get();
        }

        public MethodProperty setType(String type) {
            this.type.set(type);
            return this;
        }

        public String getName() {
            return name.get();
        }

        public MethodProperty setName(String name) {
            this.name.set(name);
            return this;
        }

        public String getParameter() {
            return parameter.get();
        }

        public MethodProperty setParameter(String parameter) {
            this.parameter.set(parameter);
            return this;
        }

        public String getException() {
            return exception.get();
        }

        public MethodProperty setException(String exception) {
            this.exception.set(exception);
            return this;
        }

    }

}
